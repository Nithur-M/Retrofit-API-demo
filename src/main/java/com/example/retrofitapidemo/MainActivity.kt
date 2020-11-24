package com.example.retrofitapidemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.retrofitapidemo.post.api.PostApi
import com.example.retrofitapidemo.post.model.Posts
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var rf = Retrofit.Builder()
            .baseUrl(PostApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()

        var API = rf.create(PostApi::class.java)
        var call = API.posts

        call?.enqueue(object: Callback<List<Posts?>?>{
            override fun onFailure(call: Call<List<Posts?>?>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call<List<Posts?>?>, response: Response<List<Posts?>?>) {
                var postList : List<Posts>? = response.body() as List<Posts>
                var post = arrayOfNulls<String>(postList!!.size)

                for(i in postList!!.indices)
                    post[i] = postList!![i]!!.title

                var adapter = ArrayAdapter<String>(applicationContext,android.R.layout.simple_dropdown_item_1line,post)
                findViewById<ListView>(R.id.listview).adapter = adapter
            }


        })

    }
}