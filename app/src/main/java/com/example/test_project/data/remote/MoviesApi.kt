package com.example.test_project.data.remote

import com.example.test_project.domain.model.MoviesData
import retrofit2.http.GET

interface MoviesApi {
    @GET("3/tv/popular?api_key=5d967c7c335764f39b1efbe9c5de9760&page=4")
    suspend fun getMovies(): MoviesData
}
