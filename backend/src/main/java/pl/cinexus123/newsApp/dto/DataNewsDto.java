package pl.cinexus123.newsApp.dto;

import java.util.List;

import lombok.Data;

@Data
public class DataNewsDto {

	private int results;
	private String status;
	private List<ArticleDto> articles;
}
