package com.example.pokemonapp.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pokemonapp.viewModel.PokemonViewModel

@Composable
fun PokemonListScreen(viewModel: PokemonViewModel = viewModel()) {

    val pokemonList = viewModel.pokemonList.observeAsState(emptyList())

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(modifier = Modifier.weight(1f)) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxSize()
            ) {
                items(pokemonList.value) { pokemon ->
                    PokemonCard(pokemon = pokemon)
                }
            }
        }
        Button(
            onClick = { viewModel.loadRandomPokemonList() },
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(1f),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
        ) {
            Text("Reload", color = Color.White)
        }
    }
}
