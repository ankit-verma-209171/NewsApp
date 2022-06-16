package com.codeitsolo.newsapp;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codeitsolo.newsapp.databinding.FragmentEntertainmentBinding;
import com.codeitsolo.newsapp.databinding.FragmentHealthBinding;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HealthFragment extends Fragment {

    FragmentHealthBinding binding;
    ArrayList<NewsArticle> articles;
    NewsArticleAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHealthBinding.inflate(inflater, container, false);

        binding.rvHealth.setLayoutManager(new LinearLayoutManager(getContext()));
        articles = new ArrayList<>();
        adapter = new NewsArticleAdapter(getContext(), articles);
        binding.rvHealth.setAdapter(adapter);

        findNews();

        return binding.getRoot();
    }

    private void findNews() {
        ApiUtilities
                .getNewsApiInterface()
                .getCategoryNewsArticles(
                        "in",
                        "health",
                        100,
                        getString(R.string.api_key))
                .enqueue(new Callback<NewsArticleList>() {
                    @SuppressLint("NotifyDataSetChanged")
                    @Override
                    public void onResponse(Call<NewsArticleList> call, Response<NewsArticleList> response) {
                        if (response.isSuccessful()) {
                            if (response.body() != null) {
                                articles.addAll(response.body().getArticles());
                                adapter.notifyDataSetChanged();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<NewsArticleList> call, Throwable t) {

                    }
                });
    }
}