package com.example.pokemonapp.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemonapp.api.PokemonInstance
import com.example.pokemonapp.model.Pokemon
import kotlinx.coroutines.launch
import kotlin.random.Random

class PokemonViewModel : ViewModel() {

    private val pokemonApi = PokemonInstance.pokemonApi
    private val _pokemonList = MutableLiveData<List<Pokemon>>()
    val pokemonList: LiveData<List<Pokemon>> = _pokemonList

    private fun loadRandomPokemonList() {
        viewModelScope.launch {
            val newList = mutableSetOf<Pokemon>()
            val usedIds = mutableSetOf<Int>()

            while (newList.size < 15) {
                val randomId = Random.nextInt(1, 1025)

                if (randomId !in usedIds) {
                    val response = try {
                        pokemonApi.getPokemon(randomId.toString())
                    } catch (exception: Exception) {
                        null
                    }
                    response?.body()?.let {
                        newList.add(it)
                        usedIds.add(randomId)
                    }
                }
            }
            _pokemonList.value = newList.toList()
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
