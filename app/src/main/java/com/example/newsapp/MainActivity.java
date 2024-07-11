package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.example.newsapp.AdapterClasses.FragmentAdapter;
import com.example.newsapp.Interface.NewsInterface;
import com.example.newsapp.ModelClasses.NewsArray;
import com.google.android.material.tabs.TabLayout;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    TabLayout tabs;
    ViewPager viewPager;
    String API_KEY = "ff399ec8756c4e5ca98b468bc627dace";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Window window = getWindow();

        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(getResources().getColor(R.color.white));

        tabs = findViewById(R.id.Tab_layout);
        viewPager = findViewById(R.id.View_pager);

        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabs.setupWithViewPager(viewPager);



    }

}