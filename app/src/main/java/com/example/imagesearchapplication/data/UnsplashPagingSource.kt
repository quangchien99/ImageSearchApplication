package com.example.imagesearchapplication.data

import android.util.Log
import androidx.paging.PagingSource
import com.example.imagesearchapplication.api.UnsplashApi
import com.example.imagesearchapplication.utils.utilConsts.Const
import retrofit2.HttpException
import java.io.IOException

class UnsplashPagingSource(
    private val unsplashApi: UnsplashApi,
    private val query: String
) : PagingSource<Int, UnsplashPhoto>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UnsplashPhoto> {
        val position = params.key ?: Const.UNSPLASH_STARTING_INDEX

        return try {
            val response = unsplashApi.searchPhotos(query, position, params.loadSize)
            val photos = response.results
            Log.e("ChienPQ2", "UnsplashPagingSource.load: ${photos.size}")
            LoadResult.Page(
                data = photos,
                prevKey = if (position == Const.UNSPLASH_STARTING_INDEX) null else position - 1,
                nextKey = if (photos.isEmpty()) null else position + 1
            )
        }
        catch (exception: IOException) {
            LoadResult.Error(exception)
        }
        catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }
}