package com.codeitsolo.newsapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class NewsArticleAdapter extends RecyclerView.Adapter<NewsArticleAdapter.ViewHolder> {

    private Context context;
    private ArrayList<NewsArticle> newsArticles;

    public NewsArticleAdapter(Context context, ArrayList<NewsArticle> newsArticles) {
        this.context = context;
        this.newsArticles = newsArticles;
    }

    @NonNull
    @Override
    public NewsArticleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.news_item, null, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsArticleAdapter.ViewHolder holder, int position) {
        NewsArticle newsArticle = newsArticles.get(position);

        holder.cardView.setOnClickListener(view -> {
            Intent intent = new Intent(context, NewsArticleWebViewActivity.class);
            intent.putExtra("url", newsArticle.getUrl());
            context.startActivity(intent);
        });

        holder.time.setText(String.format("Published At :- %s", newsArticle.getPublishedAt()));
        holder.author.setText(newsArticle.getAuthor());
        holder.mainHeading.setText(newsArticle.getTitle());
        holder.content.setText(newsArticle.getDescription());
        Glide.with(context).load(newsArticle.getUrlToImage()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return newsArticles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView mainHeading, content, author, time;
        ImageView imageView;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.card_view);
            mainHeading = itemView.findViewById(R.id.main_heading);
            content = itemView.findViewById(R.id.content);
            author = itemView.findViewById(R.id.author);
            time = itemView.findViewById(R.id.time);
            imageView = itemView.findViewById(R.id.image_view);
        }
    }
}
