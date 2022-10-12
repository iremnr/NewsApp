package com.example.newsapp.data.remote

import com.example.newsapp.data.model.Kategori
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface KategoriAPI {

    @GET("news")
    fun getCategory(
        @Query("category")name:String
    ): Call<Kategori>
}