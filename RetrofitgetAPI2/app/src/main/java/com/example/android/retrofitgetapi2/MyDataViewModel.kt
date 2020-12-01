package com.example.android.retrofitgetapi2

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyDataViewModel: ViewModel() {

    // The internal MutableLiveData String that stores the most recent response
    private val _liveData = MutableLiveData<ArrayList<MyDataItem>>()

    // The external immutable LiveData for the response String
    val liveData: LiveData<ArrayList<MyDataItem>>
        get() = _liveData

    /**
     * Call getUserData() on init so we can display status immediately.
     */
    init {
        Log.i("_response", "this is the response")
        getUsersData()
    }

    /**
     * Sets the value of the status LiveData to the Users API status.
     */
    fun getUsersData() {
        UserApi.retrofitService.getData().enqueue(
                object : Callback<ArrayList<MyDataItem>> {
                    override fun onResponse(call: Call<ArrayList<MyDataItem>>, response: Response<ArrayList<MyDataItem>>) {
                        _liveData.value = response.body()
                    }

                    override fun onFailure(call: Call<ArrayList<MyDataItem>>, t: Throwable) {

                    }

                }
        )

    }
}

