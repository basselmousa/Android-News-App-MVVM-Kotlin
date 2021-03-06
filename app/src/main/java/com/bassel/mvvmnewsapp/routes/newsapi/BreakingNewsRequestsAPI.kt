package com.bassel.mvvmnewsapp.routes.newsapi

import com.bassel.mvvmnewsapp.models.NewsResponse
import com.bassel.mvvmnewsapp.util.constants.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BreakingNewsRequestsAPI {

    @GET("v2/top-headlines")
    suspend fun getBreakingNews(
        @Query("country")
        countryCode: String = "us",
        @Query("page")
        pageNumber : Int = 1,
        @Query("apiKey")
        apiKey: String = Constants.API_KEY
    ): Response<NewsResponse>

    @GET("v2/everything")
    suspend fun searchForNews(
        @Query("q")
        searchQuery: String,
        @Query("page")
        pageNumber : Int = 1,
        @Query("apiKey")
        apiKey: String = Constants.API_KEY
    ): Response<NewsResponse>
}