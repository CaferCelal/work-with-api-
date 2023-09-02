package com.example.workwithapi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_pokemon_displayer.*

class PokemonDisplayer : AppCompatActivity() {
    private val pokemonName = "Pokemon name : "
    private val pokemonType = "Pokemon type : "
    private val pokemonAblilites = "Pokemon abilities : "
    private val pokemonHitpoint = "Pokemon hitpoint : "
    private val pokemonEvolutions = "Pokemon evolutions : "
    private val pokemonLocation = "Pokemon location : "


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_displayer)

        val pokemonData =intent.getExtraPokemonData("pokemon_data")



        pokemonData?.let { setView(it) }




    }
    private fun setView(data:PokemonDataClass){
        Picasso.get().load(data.imageUrl).into(displayPokemonImg)
        displayPokemonName.setText(pokemonName + data.pokemonName)
        displayPokemonType.setText(pokemonType + data.pokemonType)
        displayPokemonAbilities.setText(pokemonAblilites + format(data.pokemonAbilities))
        displayPokemonHitpoints.setText(pokemonHitpoint + data.pokemonHitPoints.toString())
        displayPokemonEvolutions.setText(pokemonEvolutions + format(data.pokemonEvolutions))
        displayPokemonLocation.setText(pokemonLocation + data.pokemonLocation)
    }
    fun format(abilities: ArrayList<String>?): String {
        if (abilities == null || abilities.isEmpty()) {
            return "Emty"
        }

        return abilities.joinToString(", ")
    }
}