package com.pareandroid.kotlinmovie.View

import com.pareandroid.kotlinmovie.Model.Result

interface HomeView {
    fun Onshowloading()
    fun Onhideloading()
    fun OnResponse(result : List<Result>)
    fun onFailure(error: Throwable)
}