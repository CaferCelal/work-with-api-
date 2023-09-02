package com.example.workwithapi

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: PokemonRecyclerAdapter
    private lateinit var layoutManager: LinearLayoutManager

    private val apiService = APIService()
    val pokemonList = arrayListOf<PokemonDataClass>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pullData()

        refreshLayout.setOnRefreshListener {
            pullData()
            refreshLayout.isRefreshing=false
        }

    }

    fun pullData(){
        apiService.getData()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { fetchedPokemonList ->
                    pokemonList.clear()
                    pokemonList.addAll(fetchedPokemonList)
                    setRecyclerView()
                },
                { error ->
                    // Handle errors here
                    Log.e("API", "Error fetching Pokémon", error)
                }
            )
    }

    private fun setRecyclerView(){
        adapter= PokemonRecyclerAdapter(pokemonList)
        layoutManager= LinearLayoutManager(this)
        pokemonRecyclerView.adapter=adapter
        pokemonRecyclerView.layoutManager=layoutManager
    }
}