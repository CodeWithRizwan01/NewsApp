package com.example.newsapp;

import com.example.newsapp.Interface.NewsInterface;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiUtilities {

    private static Retrofit retrofit = null;

    public static NewsInterface getNewsInterface() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(NewsInterface.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit.create(NewsInterface.class);
    }

}
