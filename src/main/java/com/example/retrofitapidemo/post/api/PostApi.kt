package com.example.retrofitapidemo.post.api

import com.example.retrofitapidemo.post.model.Posts
import retrofit2.Call
import retrofit2.http.GET

interface PostApi {

   @get:GET(
       value = "posts"
   )
    val posts : Call<List<Posts?>?>?


    companion object {
        const val BASE_URL = "https://jsonplaceholder.typicode.com"
    }

}