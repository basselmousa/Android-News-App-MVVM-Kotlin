package com.bassel.mvvmnewsapp.util.instances

import com.bassel.mvvmnewsapp.routes.newsapi.BreakingNewsRequestsAPI
import com.bassel.mvvmnewsapp.util.constants.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {

    companion object {
        private val retrofit by lazy {
            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()
            Retrofit.Builder().baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).client(client)
                .build()
        }

        val api by  lazy {
            retrofit.create(BreakingNewsRequestsAPI::class.java)
        }
    }

}