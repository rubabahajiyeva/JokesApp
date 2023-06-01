package com.rubabe.jokesapp.api

import com.rubabe.jokesapp.model.Jokes
import retrofit2.Call
import retrofit2.http.GET


interface Api {

    @GET("Any")
    fun getJokesData(): Call<Jokes>
}