package com.example.android.retrofitgetapi2

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

private val retrofitBuilder = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

interface ApiInterface {
    @GET("posts")
    fun getData() : Call<ArrayList<MyDataItem>>
}

object UserApi {
    val retrofitService : ApiInterface by lazy {
        retrofitBuilder.create(ApiInterface::class.java)
    }
}





