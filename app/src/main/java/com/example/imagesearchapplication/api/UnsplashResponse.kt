package com.example.imagesearchapplication.api

import com.example.imagesearchapplication.data.UnsplashPhoto

data class UnsplashResponse(
    val results: List<UnsplashPhoto>
) {
}