package com.example.pokemonapp.service

import com.example.pokemonapp.model.Pokemon
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApi {
    @GET("pokemon/{id}")
    suspend fun getPokemon(@Path("id") pokemonId: String): Response<Pokemon>
}