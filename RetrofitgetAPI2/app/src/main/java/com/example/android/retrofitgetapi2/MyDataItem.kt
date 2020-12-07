package com.example.android.retrofitgetapi2

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "my_data_item")
data class MyDataItem(
        @ColumnInfo(name = "body")
        val body: String,
        @PrimaryKey(autoGenerate = true)
        val id: Int,
        @ColumnInfo(name = "title")
        val title: String,
        @ColumnInfo(name = "userId")
        val userId: Int
)



