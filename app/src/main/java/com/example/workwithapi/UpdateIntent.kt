package com.example.workwithapi

import android.content.Intent
import android.os.Bundle


fun Intent.PutExtra(key: String, value: PokemonDataClass?) {
    if (value == null || value.isNullOrEmpty()) {
        removeExtra(key)
        return
    }

    val bundle = extras ?: Bundle() // Create a new Bundle if extras is null

    if (!bundle.containsKey(key)) {
        bundle.putParcelable(key, value)
    }

    putExtras(bundle) // Set the new Bundle as the extras for the Intent
}
fun Intent.getExtraPokemonData(key: String): PokemonDataClass? {
    val bundle = extras
    if (bundle != null) {
        return bundle.getParcelable(key)
    }
    return null
}


