package com.example.test_project.di

import com.example.test_project.data.repository.MoviesRepositoryImpl
import com.example.test_project.domain.repository.MoviesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindMoviesRepository(moviesRepositoryImpl: MoviesRepositoryImpl): MoviesRepository
}
