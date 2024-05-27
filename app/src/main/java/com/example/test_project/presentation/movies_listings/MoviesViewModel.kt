package com.example.test_project.presentation.movies_listings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test_project.domain.model.MoviesData
import com.example.test_project.domain.repository.MoviesRepository
import com.example.test_project.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel
    @Inject
    constructor(private val repository: MoviesRepository) : ViewModel() {
        private val _movieList = MutableStateFlow<Resource<MoviesData>>(Resource.Loading)
        val movieList: MutableStateFlow<Resource<MoviesData>> = _movieList

        fun fetchMovies() {
            viewModelScope.launch(Dispatchers.IO) {
                _movieList.value = Resource.Loading
                _movieList.value = repository.fetchMovies()
            }
        }
    }
