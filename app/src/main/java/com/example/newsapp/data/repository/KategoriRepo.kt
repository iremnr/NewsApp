package com.example.newsapp.data.repository

import androidx.lifecycle.MutableLiveData
import com.example.newsapp.common.Retrofit
import com.example.newsapp.data.model.Kategori
import retrofit2.Callback
import retrofit2.Call
import retrofit2.Response

class KategoriRepo {

    fun list(category:String):MutableLiveData<Kategori>{

        val result = MutableLiveData<Kategori>()

        Retrofit.kategori().getCategory(category).enqueue(object:Callback<Kategori>{

            override fun onResponse(call: Call<Kategori>, response: Response<Kategori>) {

                if(response.isSuccessful){

                    result.value=response.body()
                }
            }

            override fun onFailure(call: Call<Kategori>, t: Throwable) {}

        })

        return result
    }

}