package com.codeitsolo.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebViewClient;

import com.codeitsolo.newsapp.databinding.ActivityNewsArticleWebViewBinding;

public class NewsArticleWebViewActivity extends AppCompatActivity {

    ActivityNewsArticleWebViewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNewsArticleWebViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);

        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        binding.webView.setWebViewClient(new WebViewClient());
        binding.webView.loadUrl(url);
    }
}