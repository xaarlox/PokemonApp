package com.example.pokemonapp.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PokemonInstance {

    private const val baseUrl = "https://pokeapi.co/api/v2/";

    private fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val pokemonApi: PokemonApi = getInstance().create(PokemonApi::class.java)
}