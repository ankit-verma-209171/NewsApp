package com.codeitsolo.newsapp;

import java.util.ArrayList;

public class NewsArticleList {

    private String status;
    private String totalResults;
    private ArrayList<NewsArticle> articles;

    public NewsArticleList(String status, String totalResults, ArrayList<NewsArticle> articles) {
        this.status = status;
        this.totalResults = totalResults;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public ArrayList<NewsArticle> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<NewsArticle> articles) {
        this.articles = articles;
    }
}
