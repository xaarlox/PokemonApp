package com.example.pokemonapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemonapp.api.PokemonInstance
import com.example.pokemonapp.model.Pokemon
import kotlinx.coroutines.launch

class PokemonViewModel : ViewModel() {

    private val pokemonApi = PokemonInstance.pokemonApi
    private val _pokemonList = MutableLiveData<List<Pokemon>>()
    private val totalPokemon = 1025
    private val pokemonListSize = 15
    val pokemonList: LiveData<List<Pokemon>> = _pokemonList

    fun loadRandomPokemonList() {
        _pokemonList.value = emptyList()
        viewModelScope.launch {
            val randomIds = (1..totalPokemon).shuffled().take(pokemonListSize)
            val newList = mutableListOf<Pokemon>()

            randomIds.forEach { id ->
                val response = try {
                    pokemonApi.getPokemon(id.toString())
                } catch (exception: Exception) {
                    null
                }
                response?.body()?.let { newList.add(it) }
            }
            _pokemonList.value = newList
        }
    }

    fun sortByName() {
        _pokemonList.value = _pokemonList.value?.sortedBy { it.name }
    }

    fun sortByNameReverse() {
        _pokemonList.value = _pokemonList.value?.sortedByDescending { it.name }
    }

    fun sortByMoves() {
        _pokemonList.value = _pokemonList.value?.sortedWith(
            compareBy(
                { it.moves.getOrNull(0)?.move?.name ?: "" },
                { it.moves.getOrNull(1)?.move?.name ?: "" }
            )
        )
    }

    fun sortByMovesReverse() {
        _pokemonList.value = _pokemonList.value?.sortedWith(
            compareByDescending<Pokemon> { it.moves.getOrNull(0)?.move?.name ?: "" }
                .thenByDescending { it.moves.getOrNull(1)?.move?.name ?: "" }
        )
    }

    init {
        loadRandomPokemonList()
    }

}
