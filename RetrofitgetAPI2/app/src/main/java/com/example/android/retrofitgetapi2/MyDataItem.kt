package com.example.android.retrofitgetapi2

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "my_data_item")
data class MyDataItem(
        @PrimaryKey(autoGenerate = true)
        val id: Int,
        @ColumnInfo(name = "body")
        val body: String,
        @ColumnInfo(name = "title")
        var title: String,
        @ColumnInfo(name = "userId")
        val userId: Int
)



