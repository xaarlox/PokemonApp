package com.example.pokemonapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.Surface
import com.example.pokemonapp.ui.PokemonListScreen
import com.example.pokemonapp.ui.theme.PokemonAppTheme
import com.example.pokemonapp.ui.PokemonViewModel

class MainActivity : ComponentActivity() {

    private val viewModel: PokemonViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PokemonAppTheme {
                Surface {
                    PokemonListScreen(viewModel)
                }
            }
        }
    }
}
