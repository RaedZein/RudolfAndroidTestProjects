package com.example.android.retrofitgetapi2

data class MyResponse(
        val body: String,
        val id: Int,
        val title: String,
        val userId: Int,
)

data class Failure(
        val message: String = "General Error: Failed Response!"
)
