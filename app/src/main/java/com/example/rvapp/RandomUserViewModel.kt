package com.example.rvapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.rvapp.data.RandomUser

class RandomUserViewModel constructor(application: Application) : AndroidViewModel(application) {


    private var randomUserDao: RandomUserDao

    init {
        randomUserDao = RandomUserDao.getInstance(this.getApplication())
    }

    fun addUsers() {
        randomUserDao.addUsers()
    }

    fun getUsers(): MutableLiveData<List<RandomUser>> {
        return randomUserDao.getUsers()
    }
}