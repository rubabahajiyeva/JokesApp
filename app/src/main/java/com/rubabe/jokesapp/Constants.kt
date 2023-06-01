package com.rubabe.jokesapp

import com.rubabe.jokesapp.api.Api
import com.rubabe.jokesapp.network.RetrofitClient

class Constants {
    companion object{
        val BASE_URL = "https://v2.jokeapi.dev/joke/"

        fun getApi(): Api {
            return RetrofitClient.getClient(BASE_URL).create(Api::class.java)
        }
    }
}