package pl.cinexus123.newsApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import pl.cinexus123.newsApp.entity.DataNews;
import pl.cinexus123.newsApp.services.DataNewsService;

@RestController
public class DataNewsController {

	private final DataNewsService dataNewsService;

	@Autowired
	public DataNewsController(DataNewsService dataNewsService) {
		super();
		this.dataNewsService = dataNewsService;
	}

	@GetMapping("/news/{country}/{category}")
	public ResponseEntity<DataNews> getAllNews(@PathVariable("country") String country,
			@PathVariable("category") String category) {

		DataNews listOfAllNews;

		try {
			listOfAllNews = dataNewsService.getListOfNews(country, category);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(new DataNews(), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(listOfAllNews, HttpStatus.OK);
	}
}
