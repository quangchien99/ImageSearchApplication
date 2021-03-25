package com.example.imagesearchapplication.ui.gallery

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.imagesearchapplication.data.UnsplashRepository

class GalleryViewModel @ViewModelInject constructor(
    private val unsplashRepository: UnsplashRepository,
    @Assisted state: SavedStateHandle
) : ViewModel() {

    private val currentQuery = state.getLiveData(CURRENT_QUERY, DEFAULT_QUERY)
    val photos = currentQuery.switchMap { queryString ->
        unsplashRepository.getSearchResource(queryString).cachedIn(viewModelScope)
    }

    fun searchPhotos(query: String) {
        currentQuery.value = query
    }

    companion object {
        private const val CURRENT_QUERY = "current_query"
        private const val DEFAULT_QUERY = "cats"
    }
}