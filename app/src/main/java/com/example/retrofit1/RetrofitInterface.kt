package com.example.retrofit1

import retrofit2.Call
import retrofit2.http.GET

interface RetrofitInterface {
    @GET("/public-api/posts")
    fun getdata (): Call<Data>
    ///public-api/posts
    //comments
}