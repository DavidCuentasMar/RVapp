package com.example.rvapp

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.example.rvapp.data.RandomUser
import org.json.JSONObject

class RandomUserDao private constructor(var context: Context) {

    private val users = MutableLiveData<List<RandomUser>>()
    private val userList = mutableListOf<RandomUser>()
    private var queue: RequestQueue

    init {
        queue = VolleySingleton.getInstance(context).requestQueue
    }

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
        VolleySingleton.getInstance(context).addToRequestQueue(getJsonObject())
    }

    fun getUsers() = users

    fun getJsonObject(): JsonObjectRequest {
        val url = "https://randomuser.me/api/?results=20"

        return JsonObjectRequest(
            Request.Method.GET, url, null,
            Response.Listener { response ->
                parseObject(response)
            },
            Response.ErrorListener { error ->
                Log.d("WebRequestTest", "That didn't work ${error.message}")
            }
        )
    }

    private fun parseObject(response: JSONObject) {
        var list = RandomUser.getUser(response)
        val size: Int = list.size
        for (i in 0 until size) {
            val user = list[i]
            userList.add(user)
        }
        users.value = userList
    }

}