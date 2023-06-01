package com.rubabe.jokesapp.viewmodel

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rubabe.jokesapp.Constants
import com.rubabe.jokesapp.api.Api
import com.rubabe.jokesapp.model.Jokes
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel: ViewModel() {
    lateinit var api: Api
    var jokesLiveData = MutableLiveData<Jokes>()

    fun getJokes(context : Context) {
        api = Constants.getApi()
        api.getJokesData().enqueue(object: Callback<Jokes> {
            override fun onResponse(call: Call<Jokes>, response: Response<Jokes>) {
                val data: Jokes? = response.body()
                this@MainActivityViewModel.jokesLiveData.postValue(data)
            }

            override fun onFailure(call: Call<Jokes>, t: Throwable) {
                Toast.makeText(context, "An error has occurred", Toast.LENGTH_LONG).show()
            }

        })

    }
}