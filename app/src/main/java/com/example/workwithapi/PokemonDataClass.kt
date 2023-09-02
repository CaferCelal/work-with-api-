package com.example.workwithapi

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class PokemonDataClass(
    @SerializedName("id")
    val PokemonID: String?,
    @SerializedName("pokemon")
    val pokemonName: String?,
    @SerializedName("type")
    val pokemonType: String?,
    @SerializedName("abilities")
    val pokemonAbilities: ArrayList<String>?,
    @SerializedName("hitpoints")
    val pokemonHitPoints: Int?,
    @SerializedName("evolutions")
    val pokemonEvolutions: ArrayList<String>?,
    @SerializedName("location")
    val pokemonLocation: String?,
    @SerializedName("image_url")
    val imageUrl: String?
) : Parcelable {

    // Parcelable implementation

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(PokemonID)
        parcel.writeString(pokemonName)
        parcel.writeString(pokemonType)
        parcel.writeStringList(pokemonAbilities)
        pokemonHitPoints?.let { parcel.writeInt(it) }
        parcel.writeStringList(pokemonEvolutions)
        parcel.writeString(pokemonLocation)
        parcel.writeString(imageUrl)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PokemonDataClass> {
        override fun createFromParcel(parcel: Parcel): PokemonDataClass {
            val pokemonID = parcel.readString()
            val pokemonName = parcel.readString()
            val pokemonType = parcel.readString()
            val pokemonAbilities = ArrayList<String>()
            parcel.readStringList(pokemonAbilities)
            val pokemonHitPoints = parcel.readInt()
            val pokemonEvolutions = ArrayList<String>()
            parcel.readStringList(pokemonEvolutions)
            val pokemonLocation = parcel.readString()
            val imageUrl = parcel.readString()
            return PokemonDataClass(
                pokemonID,
                pokemonName,
                pokemonType,
                pokemonAbilities,
                pokemonHitPoints,
                pokemonEvolutions,
                pokemonLocation,
                imageUrl
            )
        }

        override fun newArray(size: Int): Array<PokemonDataClass?> {
            return arrayOfNulls(size)
        }
    }

    // Function to check if all fields are null or empty
    fun isNullOrEmpty(): Boolean {
        return PokemonID.isNullOrEmpty() &&
                pokemonName.isNullOrEmpty() &&
                pokemonType.isNullOrEmpty() &&
                (pokemonAbilities == null || pokemonAbilities.isEmpty()) &&
                (pokemonHitPoints == null || pokemonHitPoints == 0) &&
                (pokemonEvolutions == null || pokemonEvolutions.isEmpty()) &&
                pokemonLocation.isNullOrEmpty() &&
                imageUrl.isNullOrEmpty()
    }
}


