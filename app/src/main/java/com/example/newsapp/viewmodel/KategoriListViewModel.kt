package com.example.newsapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsapp.data.model.Kategori
import com.example.newsapp.data.repository.KategoriRepo

class KategoriListViewModel : ViewModel() {

    private var kategoriRepo = KategoriRepo()
    val kategoriler = MutableLiveData<List<Kategori>>()
    val errorMessage = MutableLiveData<Boolean>()
    val categoryUploading = MutableLiveData<Boolean>()

    fun list(category:String):MutableLiveData<Kategori>{

        return kategoriRepo.list(category)
    }

}