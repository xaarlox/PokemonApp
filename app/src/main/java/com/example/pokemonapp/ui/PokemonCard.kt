package com.example.pokemonapp.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.pokemonapp.model.Pokemon

@Composable
fun PokemonCard(pokemon: Pokemon) {
    Card(
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
        modifier = Modifier.padding(20.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(15.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = pokemon.sprites.front_default,
                contentDescription = pokemon.name,
                modifier = Modifier.size(120.dp)
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = pokemon.name, fontWeight = FontWeight.Bold)
            pokemon.moves.take(2).forEach { move ->
                Text(text = move.move.name) }
        }
    }
}