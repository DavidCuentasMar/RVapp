package com.example.rvapp

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.example.rvapp.data.RandomUser

class RandomUserDao private constructor(var context: Context) {

    private val users = MutableLiveData<List<RandomUser>>()
    private val userList = mutableListOf<RandomUser>()

    companion object {
        @Volatile
        private var INSTANCE: RandomUserDao? = null

        fun getInstance(context: Context) =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: RandomUserDao(context).also {
                    INSTANCE = it
                }
            }
    }

    fun addUsers() {

    }

    fun getUsers() = users


}