package com.example.doginfo.network

import com.example.doginfo.model.DogImageResponse
import retrofit2.http.GET

interface DogApiService {
    @GET("v1/images/search?limit=20")
    suspend fun getDogs(): List<DogImageResponse>
}