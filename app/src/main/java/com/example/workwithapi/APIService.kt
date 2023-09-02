package com.example.workwithapi

import io.reactivex.rxjava3.core.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class APIService {
    val BASE_URL="https://dummyapi.online/"
    val api =Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create()) // Use RxJava 3 adapter
        .build()
        .create(GetAPI::class.java)

    fun getData(): Single<List<PokemonDataClass>> {
        return api.getPokemons()
    }
}