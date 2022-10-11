package com.example.newsapp.model

import android.provider.ContactsContract
import com.google.gson.annotations.SerializedName


data class Kategori(
    val success: String,
    val category: Int,
    val data: List<Data>
    ) {
}