package com.example.lab09.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab09.model.PokemonDetail
import com.example.lab09.model.PokemonListItem
import com.example.lab09.model.PokemonListResponse
import com.example.lab09.service.PokeApiClient
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.StateFlow

class PokemonViewModel : ViewModel() {

    // ========== Lista de Pokémon ==========
    private val _pokemonList = MutableStateFlow<List<PokemonListItem>>(emptyList())
    val pokemonList: StateFlow<List<PokemonListItem>> = _pokemonList.asStateFlow()

    // ========== Detalle de un Pokémon ==========
    private val _pokemonDetail = MutableStateFlow<PokemonDetail?>(null)
    val pokemonDetail: StateFlow<PokemonDetail?> = _pokemonDetail.asStateFlow()

    // ========== Estados de carga y error ==========
    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> = _loading.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error.asStateFlow()

    // ========== Cargar lista (20 Pokémon) ==========
    fun loadPokemonList() {
        viewModelScope.launch {
            _loading.value = true
            _error.value = null
            try {
                val response: PokemonListResponse = PokeApiClient.api.getPokemonList(limit = 20, offset =
                    0)
                _pokemonList.value = response.results
            } catch (e: Exception) {
                _error.value = e.message
            } finally {
                _loading.value = false
            }
        }
    }

    // ========== Cargar detalle por nombre ==========
    fun loadPokemonDetail(name: String) {
        viewModelScope.launch {
            _loading.value = true
            _error.value = null
            try {
                val detail: PokemonDetail = PokeApiClient.api.getPokemonDetail(name)
                _pokemonDetail.value = detail
            } catch (e: Exception) {
                _error.value = e.message
            } finally {
                _loading.value = false
            }
        }
    }
}