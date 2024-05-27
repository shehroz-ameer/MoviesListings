package com.example.test_project.domain.repository

import com.example.test_project.domain.model.MoviesData
import com.example.test_project.utils.Resource

interface MoviesRepository {
    suspend fun fetchMovies(): Resource<MoviesData>
}
