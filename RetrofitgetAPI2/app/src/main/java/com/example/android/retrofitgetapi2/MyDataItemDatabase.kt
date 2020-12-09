package com.example.android.retrofitgetapi2

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [MyDataItem::class], version = 1, exportSchema = false)
abstract class MyDataItemDatabase: RoomDatabase() {
    abstract val MyDataItemDao: MyDataItemDao
    companion object {
        @Volatile
        private var INSTANCE: MyDataItemDatabase? = null
        fun getInstance(context: Context): MyDataItemDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        MyDataItemDatabase::class.java,
                        "data_item_history_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance

                }
                return instance
            }
        }
    }
}