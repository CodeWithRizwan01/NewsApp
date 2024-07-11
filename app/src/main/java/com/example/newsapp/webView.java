package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class webView extends AppCompatActivity {
WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        webView = findViewById(R.id.webView);

        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        // Enable JavaScript
        webView.getSettings().setJavaScriptEnabled(true);

        // Enable built-in zoom controls
        WebSettings webSettings = webView.getSettings();
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false); // Hide the default zoom controls

        // Enable pinch-to-zoom
        webSettings.setSupportZoom(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);

        webView.setWebViewClient(new WebViewClient());

        if (url != null) {
            webView.loadUrl(url);
        } else {
            Log.e("WebViewActivity", "URL is null");
        }
    }
}