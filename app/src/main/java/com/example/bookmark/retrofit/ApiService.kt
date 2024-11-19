package com.example.bookmark.retrofit

import com.example.bookmark.ApiResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {
    @GET("character")
    suspend fun getCharacter(): ApiResponse  // Menggunakan suspend untuk pemanggilan asynchronous

    companion object {
        val endpoint: ApiService by lazy {
            Retrofit.Builder()
                .baseUrl("https://api.disneyapi.dev/") // Base URL API Anda
                .addConverterFactory(GsonConverterFactory.create()) // Konverter JSON ke objek
                .build()
                .create(ApiService::class.java) // Buat instance ApiService
        }
    }
}
