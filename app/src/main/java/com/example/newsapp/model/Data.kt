package com.example.newsapp.model

import com.google.gson.annotations.SerializedName

data class Data (

    val author: String,
    val title: String,

    val content: String,

    val date: String,

    val imageUrl: String,

    val readMoreUrl: String,

    val time: String,

    val url: String
        ) {
}