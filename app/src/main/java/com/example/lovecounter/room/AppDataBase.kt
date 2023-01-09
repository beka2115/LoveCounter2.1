package com.example.lovecounter.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.lovecounter.remote.LoveModel

@Database(entities = [LoveModel::class], version = 1)
abstract class AppDataBase : RoomDatabase(){

    abstract fun getDao(): LoveDao

}