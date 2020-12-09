package com.example.android.retrofitgetapi2

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface MyDataItemDao {
    @Insert
    fun insert(data: MyDataItem)
    @Update
    fun update(data: MyDataItem)
    @Query("SELECT * FROM my_data_item WHERE userId = :key")
    fun get(key: Int): MyDataItem?
    @Query("DELETE FROM my_data_item")
    fun clear()
    @Query("SELECT * FROM my_data_item ORDER BY id DESC LIMIT 1")
    fun getOneDataItem(): MyDataItem?
    @Query("SELECT * FROM my_data_item ORDER BY id DESC")
    fun getAllDataItems(): LiveData<List<MyDataItem>>
}