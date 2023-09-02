package com.example.workwithapi

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface GetAPI {
    @GET("api/pokemon")
    fun getPokemons(): Single<List<PokemonDataClass>>
}