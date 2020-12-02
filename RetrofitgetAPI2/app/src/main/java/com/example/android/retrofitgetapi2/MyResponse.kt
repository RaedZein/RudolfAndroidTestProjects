package com.example.android.retrofitgetapi2

data class MyResponse(
        val failure: Failure? = null,
        val success: ArrayList<MyDataItem>? = null
)

data class Failure(
        val message: String = "General Error: Failed Response!"
)
