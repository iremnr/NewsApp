package com.example.newsapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.R
import com.example.newsapp.adapter.KategoriGridAdapter
import com.example.newsapp.model.Data
import com.example.newsapp.model.Kategori
import com.example.newsapp.service.KategoriAPIService
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class KategoriListViewModel : ViewModel() {

    val kategoriler = MutableLiveData<List<Kategori>>()
    val errorMessage = MutableLiveData<Boolean>()
    val categoryUploading = MutableLiveData<Boolean>()

    private val kategoriApiServis = KategoriAPIService()
    private val disposable = CompositeDisposable()

    fun refreshData(categoryName: String) {
        getDataFromNet(categoryName)
    }

    private fun getDataFromNet(categoryName: String) {

        categoryUploading.value = true

        disposable.add(
            kategoriApiServis.getData(categoryName)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<Kategori>>() {
                    override fun onSuccess(t: List<Kategori>) {
                        //başarılı
                        kategoriler.value = t
                        errorMessage.value = false
                        categoryUploading.value = false
                    }

                    override fun onError(e: Throwable) {
                        //hata

                        errorMessage.value = true
                        categoryUploading.value = false
                    }

                })
        )

    }

}