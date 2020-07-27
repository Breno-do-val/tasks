package com.example.tasks.service.repository

import android.content.Context
import com.example.tasks.R
import com.example.tasks.service.model.HeaderModel
import com.example.tasks.service.constants.TaskConstants
import com.example.tasks.service.listener.APIListener
import com.example.tasks.service.repository.remote.PersonService
import com.example.tasks.service.repository.remote.RetrofitClient
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PersonRepository(val context: Context) {

    private val mRemote = RetrofitClient.createService(PersonService::class.java)
    fun login(email: String, password: String, listener: APIListener<HeaderModel>) {
        val call: Call<HeaderModel> = mRemote.login(email, password)
        //Assyncronous
        call.enqueue(object: Callback<HeaderModel>{
            override fun onFailure(call: Call<HeaderModel>, t: Throwable) {
                listener.onFailure(context.getString(R.string.ERROR_UNEXPECTED))
            }

            // The response can be null
            override fun onResponse(call: Call<HeaderModel>, response: Response<HeaderModel>) {
                if (response.code() != TaskConstants.HTTP.SUCCESS) {
                    val validation = Gson().fromJson(response.errorBody()!!.string(), String::class.java)
                    listener.onFailure(validation)
                }
                else {
                    response.body()?.let { listener.onSucess(it) }
                }
            }

        })
        //remote.login(email, password)
    }

    fun create(name: String, email: String, password: String, listener: APIListener<HeaderModel>) {
        val call: Call<HeaderModel> = mRemote.create(name, email, password)
        //Assyncronous
        call.enqueue(object: Callback<HeaderModel>{
            override fun onFailure(call: Call<HeaderModel>, t: Throwable) {
                listener.onFailure(context.getString(R.string.ERROR_UNEXPECTED))
            }

            // The response can be null
            override fun onResponse(call: Call<HeaderModel>, response: Response<HeaderModel>) {
                if (response.code() != TaskConstants.HTTP.SUCCESS) {
                    val validation = Gson().fromJson(response.errorBody()!!.string(), String::class.java)
                    listener.onFailure(validation)
                }
                else {
                    response.body()?.let { listener.onSucess(it) }
                }
            }

        })
        //remote.login(email, password)
    }
}