package com.example.newsapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.newsapp.AdapterClasses.NewsAdapter;
import com.example.newsapp.ApiUtilities;
import com.example.newsapp.Interface.NewsInterface;
import com.example.newsapp.ModelClasses.NewsArray;
import com.example.newsapp.ModelClasses.NewsModel;
import com.example.newsapp.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class TechFragment extends Fragment {

    String API_KEY = "ff399ec8756c4e5ca98b468bc627dace";
    RecyclerView recyclerViewTech;
    ArrayList<NewsModel> arrayList;
    String country = "us";
    NewsAdapter adapter;
    String category = "technology";
    public TechFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tech, container, false);

        recyclerViewTech = view.findViewById(R.id.techRecyclerview);
        arrayList = new ArrayList<>();
        recyclerViewTech.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new NewsAdapter(getContext(),arrayList);
        recyclerViewTech.setAdapter(adapter);

        findNews();

        return view;
    }
    private void findNews() {
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://newsapi.org/v2/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        NewsInterface newsInterface = retrofit.create(NewsInterface.class);
//        Call<NewsArray> call = newsInterface.getCategoryNews(country,100,category,API_KEY);
//        call.enqueue(new Callback<NewsArray>() {
//            @Override
//            public void onResponse(Call<NewsArray> call, Response<NewsArray> response) {
//                if (response.isSuccessful()){
//                    arrayList.addAll(response.body().getArticles());
//                    adapter.notifyDataSetChanged();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<NewsArray> call, Throwable throwable) {
//
//            }
//        });
        ApiUtilities.getNewsInterface().getCategoryNews(country,100,category,API_KEY).enqueue(new Callback<NewsArray>() {
            @Override
            public void onResponse(Call<NewsArray> call, Response<NewsArray> response) {
                if (response.isSuccessful()) {
                    arrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<NewsArray> call, Throwable throwable) {

            }
        });
    }

}