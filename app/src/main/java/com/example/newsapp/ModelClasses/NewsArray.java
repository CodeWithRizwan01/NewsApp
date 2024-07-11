package com.example.newsapp.ModelClasses;

import java.util.ArrayList;

public class NewsArray {
    private String status;
    private String totalResults;
    private ArrayList<NewsModel> articles;

    public String getStatus() {
        return status;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public ArrayList<NewsModel> getArticles() {
        return articles;
    }

    public NewsArray(String status, String totalResults, ArrayList<NewsModel> articles) {
        this.status = status;
        this.totalResults = totalResults;
        this.articles = articles;
    }
}
