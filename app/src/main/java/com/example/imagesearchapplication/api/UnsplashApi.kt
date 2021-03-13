package com.example.imagesearchapplication.api

import com.example.imagesearchapplication.utils.utilConsts.Const
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface UnsplashApi {


    @Headers("Accept.Version: v1", "Authorization: Client-ID ${Const.UNSPLASH_ACCESS_KEY}")
    @GET("/search/photos")
    suspend fun searchPhotos(
        @Query("query") query: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): UnsplashResponse
}