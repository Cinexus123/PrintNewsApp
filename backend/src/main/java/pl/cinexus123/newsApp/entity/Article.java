package pl.cinexus123.newsApp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Article {

	private String author;
	private String title;
	private String description;
	private String date;
	private String sourceName;
	private String articleUrl;
	private String imageUrl;

}
