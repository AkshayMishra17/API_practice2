package com.example.doginfo.model

sealed class DogListIntent {
    data object FetchDogs: DogListIntent()
}