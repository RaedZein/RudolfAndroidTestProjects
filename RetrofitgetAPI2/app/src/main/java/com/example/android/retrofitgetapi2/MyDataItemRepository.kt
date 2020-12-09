package com.example.android.retrofitgetapi2

import androidx.lifecycle.LiveData

class MyDataItemRepository(private val myDataItemDao: MyDataItemDao) {
    val getAllDataItems: LiveData<List<MyDataItem>> = myDataItemDao.getAllDataItems()

    fun insert(myDataItem: MyDataItem) {
        myDataItemDao.insert(myDataItem)
    }
}