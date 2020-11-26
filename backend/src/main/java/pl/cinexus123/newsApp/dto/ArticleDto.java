package pl.cinexus123.newsApp.dto;

import lombok.Data;

@Data
public class ArticleDto {

	private String author;
	private String title;
	private String description;
	private String url;
	private String urlToImage;
	private String publishedAt;
	private String content;
	private Source source;
}
