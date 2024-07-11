package com.example.newsapp.ModelClasses;

public class NewsModel {
    String title,publishedAt,url,urlToImage,description,author;

    public NewsModel(String title, String publishedAt, String url, String urlToImage, String description, String author) {
        this.title = title;
        this.publishedAt = publishedAt;
        this.url = url;
        this.urlToImage = urlToImage;
        this.description = description;
        this.author = author;
    }
    public String getTitle() {
        return title;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public String getUrl() {
        return url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }


    public String getDescription() {
        return description;
    }

    public String getAuthor() {
        return author;
    }

}
