package com.example.lab09.service

import com.example.lab09.model.PokemonDetail
import com.example.lab09.model.PokemonListResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeApiService {

    // Obtener lista de Pokémon (ej. 20 Pokémon empezando desde el 0)
    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): PokemonListResponse

    // Obtener el detalle de un Pokémon por su nombre (ej. "pikachu" o "ditto")
    @GET("pokemon/{name}")
    suspend fun getPokemonDetail(@Path("name") name: String): PokemonDetail
}