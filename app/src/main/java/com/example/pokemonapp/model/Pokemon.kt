package com.example.pokemonapp.model

data class Pokemon(
    val name: String,
    val sprites: Sprites,
    val moves: List<MoveWrapper>
)

data class Sprites(
    val front_default: String
)

data class MoveWrapper(
    val move: Move
)

data class Move(
    val name: String
)