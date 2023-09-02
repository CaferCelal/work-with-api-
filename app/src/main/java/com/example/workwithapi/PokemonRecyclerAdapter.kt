package com.example.workwithapi

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.pokemon_recycler_row.view.*

class PokemonRecyclerAdapter(private val pokemonList: ArrayList<PokemonDataClass>)
    : RecyclerView.Adapter<PokemonRecyclerAdapter.PokemonHolder>() {

    inner class PokemonHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun getItemCount(): Int {
        return pokemonList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.pokemon_recycler_row, parent, false)
        return PokemonHolder(view)
    }

    override fun onBindViewHolder(holder: PokemonHolder, position: Int) {
        val pokemon = pokemonList[position]
        with(holder.itemView) {
            pokemonName.text = pokemon.pokemonName
            pokemonType.text = pokemon.pokemonType
            Picasso.get().load(pokemon.imageUrl).into(pokemonImage)

            setOnClickListener {
                val intent = Intent(context, PokemonDisplayer::class.java)
                intent.PutExtra("pokemon_data", pokemon )
                context.startActivity(intent)
            }
        }
    }
}