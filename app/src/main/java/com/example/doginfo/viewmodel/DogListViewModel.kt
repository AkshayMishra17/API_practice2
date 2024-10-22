package com.example.doginfo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.doginfo.model.DogListIntent
import com.example.doginfo.model.DogListState
import com.example.doginfo.network.ApiClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DogListViewModel: ViewModel() {
    private val _state = MutableStateFlow<DogListState>(DogListState.Loading)
    val state: StateFlow<DogListState> = _state

    fun handleIntent(intent: DogListIntent){
        when(intent){
            is DogListIntent.FetchDogs -> fetchDogs()
        }
    }
    private fun fetchDogs() {
        viewModelScope.launch {
            try {
                _state.value = DogListState.Loading
                val dogs = ApiClient.apiService.getDogs()
                _state.value = DogListState.Success(dogs)
            } catch (e: Exception) {
                _state.value = DogListState.Error(e.localizedMessage ?: "An error occurred")
            }
        }
    }
}