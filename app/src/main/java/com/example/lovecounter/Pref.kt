package com.example.lovecounter

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences


class Pref{
    lateinit var pref: SharedPreferences

    fun onPref(context: Context){
        pref= context.getSharedPreferences("pref_name",MODE_PRIVATE)
    }

    fun isOnBoardingShow(): Boolean {
        return pref.getBoolean(BOARDING_SHOW, false)
    }

    fun saveShowBoarding(isShow: Boolean) {
        pref.edit().putBoolean(BOARDING_SHOW, isShow).apply()
    }


    companion object{
        private const val BOARDING_SHOW = "on_boarding_show"
    }

}