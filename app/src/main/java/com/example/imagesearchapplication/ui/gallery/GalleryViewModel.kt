package com.example.imagesearchapplication.ui.gallery

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.imagesearchapplication.data.UnsplashRepository
import com.example.imagesearchapplication.utils.utilConsts.Const

class GalleryViewModel @ViewModelInject constructor(private val unsplashRepository: UnsplashRepository) :
    ViewModel() {
    private val currentQuery = MutableLiveData(Const.DEFAULT_QUERY)
    val photos = currentQuery.switchMap { queryString ->
        unsplashRepository.getSearchResource(queryString).cachedIn(viewModelScope)
    }

    fun searchPhotos(query: String) {
        currentQuery.value = query
    }
}