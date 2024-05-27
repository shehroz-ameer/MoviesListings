package com.example.test_project.data.repository

import com.example.test_project.data.remote.MoviesApi
import com.example.test_project.domain.model.MoviesData
import com.example.test_project.domain.repository.MoviesRepository
import com.example.test_project.utils.Resource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MoviesRepositoryImpl
    @Inject
    constructor(private val api: MoviesApi) : MoviesRepository {
        override suspend fun fetchMovies(): Resource<MoviesData> {
            return try {
                val response = api.getMovies()
                Resource.Success(response)
            } catch (e: Exception) {
                Resource.Failure("Unable to load Movies")
            }
        }
    }
