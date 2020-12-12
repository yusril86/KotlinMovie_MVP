package com.pareandroid.kotlinmovie.Api

import com.pareandroid.kotlinmovie.BuildConfig
import com.pareandroid.kotlinmovie.Model.HomeResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface HomeDataSource {
    @GET("/3/discover/movie")
    fun discoverMovie(
        @Query("api_key")
        apiKey:String = BuildConfig.API_KEY
    ):Call<HomeResponse>
}