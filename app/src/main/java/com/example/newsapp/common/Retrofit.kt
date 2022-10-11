package com.example.newsapp.common

import com.example.newsapp.data.remote.KategoriAPI
import com.google.gson.GsonBuilder
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit

object Retrofit {

    fun kategori(): KategoriAPI {

        val category: KategoriAPI by lazy { retrofit(Constants.BASE_URL).create(KategoriAPI::class.java) }

        return category
    }


    private fun retrofit(url:String):Retrofit{

        val gson= GsonBuilder().setLenient().create()

        return Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

}