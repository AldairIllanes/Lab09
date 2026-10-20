package com.example.lab09.model

import com.google.gson.annotations.SerializedName

// ==========================================
// RESPUESTA DE LISTA (pokemon?limit=20&offset=0)
// ==========================================

data class PokemonListItem(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)

data class PokemonListResponse(
    @SerializedName("results") val results: List<PokemonListItem>
)

// ==========================================
// DETALLE DE UN POKÉMON (ej. pikachu)
// ==========================================

data class PokemonDetail(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("height") val height: Int,
    @SerializedName("weight") val weight: Int,
    @SerializedName("base_experience") val baseExperience: Int,
    @SerializedName("sprites") val sprites: Sprites,
    @SerializedName("types") val types: List<PokemonType>,
    @SerializedName("stats") val stats: List<PokemonStat>,
    @SerializedName("abilities") val abilities: List<PokemonAbility>
)

data class Sprites(
    @SerializedName("front_default") val frontDefault: String?
)

data class PokemonType(
    @SerializedName("type") val type: TypeInfo
)

data class TypeInfo(
    @SerializedName("name") val name: String
)

data class PokemonStat(
    @SerializedName("base_stat") val baseStat: Int,
    @SerializedName("stat") val stat: StatInfo
)

data class StatInfo(
    @SerializedName("name") val name: String
)

data class PokemonAbility(
    @SerializedName("ability") val ability: AbilityInfo
)

data class AbilityInfo(
    @SerializedName("name") val name: String
)