package com.example.newsapp.service

import com.example.newsapp.model.Kategori
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface KategoriAPI {

    //https://inshorts.deta.dev/news?category=all

    @GET("news")
    fun getKategori(
        @Query("category") categoryName: String
    ) : Single<List<Kategori>>

}