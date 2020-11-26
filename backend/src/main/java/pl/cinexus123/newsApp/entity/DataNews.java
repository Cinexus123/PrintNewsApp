package pl.cinexus123.newsApp.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataNews {

	private String country;
	private String category;
	private List<Article> articles;
}
