package pl.cinexus123.newsApp.services;

import pl.cinexus123.newsApp.entity.DataNews;

public interface DataNewsService {

	DataNews getListOfNews(String country, String category) throws Exception;
}
