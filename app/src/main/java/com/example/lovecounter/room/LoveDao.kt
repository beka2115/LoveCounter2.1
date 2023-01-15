package com.example.lovecounter.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.lovecounter.remote.LoveModel

@Dao
interface LoveDao {
    @Insert
    fun insertLove(model:LoveModel)

    @Query("SELECT * FROM lovemodel ORDER BY firstName ASC")
    fun getAll(): List<LoveModel>
}