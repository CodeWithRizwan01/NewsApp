package com.example.newsapp.Interface;

import com.example.newsapp.ModelClasses.NewsArray;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsInterface {

    String BASE_URL = "https://newsapi.org/v2/";
    @GET("top-headlines")
    Call<NewsArray> getNews(
            @Query("country") String country,
            @Query("pageSize") int pageSize,
            @Query("apiKey") String apiKey

    );

    @GET("top-headlines")
    Call<NewsArray> getCategoryNews(
            @Query("country") String country,
            @Query("pageSize") int pageSize,
            @Query("category") String category,
            @Query("apiKey") String apiKey

    );
}
