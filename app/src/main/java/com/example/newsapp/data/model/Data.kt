package com.example.newsapp.data.model

import com.google.gson.annotations.SerializedName

data class Data (

    val author:String?,

    val content:String?,

    val date:String?,

    @SerializedName("imageUrl")
    val image_url:String?,

    @SerializedName("readMoreUrl")
    val read_url:String?,

    val time:String?,

    val title:String?,

    val url:String?) {
}