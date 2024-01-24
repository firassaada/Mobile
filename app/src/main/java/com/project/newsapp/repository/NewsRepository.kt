package com.project.newsapp.repository

import com.project.newsapp.api.RetrofitInstance
import com.project.newsapp.db.ArticleDatabase

class NewsRepository (
    val db: ArticleDatabase
){
    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)
    suspend fun searchNews(searchQuery: String, pageNumber: Int)=
        RetrofitInstance.api.searchForNews(searchQuery, pageNumber)
}