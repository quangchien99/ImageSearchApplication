package com.example.imagesearchapplication.ui.gallery

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.imagesearchapplication.data.UnsplashRepository

class GalleryViewModel @ViewModelInject constructor(private val unsplashRepository: UnsplashRepository) :
    ViewModel() {

}