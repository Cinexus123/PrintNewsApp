package pl.cinexus123.newsApp.services;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import org.apache.http.client.utils.URIBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.time.LocalDateTime;

import pl.cinexus123.newsApp.dto.ArticleDto;
import pl.cinexus123.newsApp.dto.DataNewsDto;
import pl.cinexus123.newsApp.entity.Article;
import pl.cinexus123.newsApp.entity.DataNews;
import pl.cinexus123.newsApp.exceptions.NotFoundException;

@Service
public class DataNewsServiceImpl implements DataNewsService {

	private static final String DATE_PATTERN = "yyyy-MM-dd'T'HH:mm:ss'Z'";
	private static final String URL_API = "https://newsapi.org/v2/top-headlines";

	@Autowired
	RestTemplate restTemplate;

	@Value("${apiKey}")
	private String apiKey;

	private static final Logger logger = LoggerFactory.getLogger(DataNewsServiceImpl.class);

	public DataNews getListOfNews(String country, String category) throws Exception {

		DataNewsDto dataNewsDto = restTemplate.getForObject(prepareUrl(country, category), DataNewsDto.class);

		if (dataNewsDto != null) {
			return new DataNews(country, category, getArticles(dataNewsDto));
		} else {
			throw new NotFoundException();
		}
	}

	private List<Article> getArticles(DataNewsDto dataNewsDto) throws Exception {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_PATTERN);
		dataNewsDto.getArticles().sort(
				Comparator.comparing((ArticleDto s) -> LocalDateTime.parse(s.getPublishedAt(), formatter)).reversed());

		List<Article> articles = new ArrayList<>();
		for (ArticleDto elem : dataNewsDto.getArticles()) {
			Article article = new Article(elem.getAuthor(), elem.getTitle(), elem.getDescription(),
					getParsedDate(elem.getPublishedAt()), elem.getSource().getName(), elem.getUrl(),
					elem.getUrlToImage());
			articles.add(article);
		}
		return articles;
	}

	private String getParsedDate(String publishedAt) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_PATTERN);
		Date dateToParse = simpleDateFormat.parse(publishedAt);
		return new SimpleDateFormat("yyyy-MM-dd").format(dateToParse);
	}

	private String prepareUrl(String country, String category) {
		URL prepareUrl = null;

		try {
			prepareUrl = apiUrlRequest(country, category);

		} catch (URISyntaxException e) {
			logger.info("URISyntaxException " + e.getMessage());
			e.printStackTrace();
		} catch (MalformedURLException e) {
			logger.info("MalformedURLException " + e.getMessage());
			e.printStackTrace();
		}
		return prepareUrl.toString();
	}

	private URL apiUrlRequest(String country, String category) throws URISyntaxException, MalformedURLException {

		URIBuilder uriBuilder = new URIBuilder(URL_API);
		uriBuilder.addParameter("apiKey", apiKey);
		uriBuilder.addParameter("country", country);
		uriBuilder.addParameter("category", category);
		return uriBuilder.build().toURL();
	}

}
