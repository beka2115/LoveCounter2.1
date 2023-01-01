package com.example.lovecounter
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.lovecounter.remote.LoveModel


class LoveViewModel:ViewModel() {
    private val repository = Repository()

    fun getLiveLoveModel(firstName:String, secondName: String):LiveData<LoveModel>{
        return repository.getLiveLove(firstName,secondName)
    }

}