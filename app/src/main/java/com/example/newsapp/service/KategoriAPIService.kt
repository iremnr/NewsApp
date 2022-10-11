package com.example.newsapp.service

import com.example.newsapp.model.Kategori
import io.reactivex.Single
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class KategoriAPIService {

    //https://inshorts.deta.dev/news?category=all

    private  val BASE_URL = "https://inshorts.deta.dev/"
    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(KategoriAPI::class.java)

    fun getData(categoryName : String) : Single<List<Kategori>> {


        return api.getKategori("all")
    }

}