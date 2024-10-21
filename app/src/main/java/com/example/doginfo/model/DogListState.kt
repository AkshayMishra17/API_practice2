package com.example.doginfo.model

sealed class DogListState {
    data object Loading: DogListState()
    data class Success(val dogs: List<DogImageResponse>): DogListState()
    data class Error(val error:String) : DogListState()
}