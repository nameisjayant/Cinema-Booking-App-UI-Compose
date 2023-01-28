package com.programmingsimplified.cinemabookingapp.data

import androidx.annotation.DrawableRes
import com.programmingsimplified.cinemabookingapp.R

data class Movies(
    val movieName:String,
    @DrawableRes val poster:Int,
    val releasedData:String,
    val type:String
)

val moviesList = listOf(
    Movies(
        "Avengers EndGame",
        R.drawable.movie_1,
        "Feb, 8 2023",
        "Premieres"
    ),
    Movies(
        "Los ojos de Tammy Faye",
        R.drawable.movie_2,
        "Feb, 8 2023",
        "Top Rated"
    ),
    Movies(
        "Spiderman: Far from home",
        R.drawable.movie_3,
        "Feb, 8 2023",
        "Premieres"
    ),
    Movies(
        "Belfast",
        R.drawable.movie_4,
        "Feb, 8 2023",
        "Premieres"
    ),
    Movies(
        "MoonFall",
        R.drawable.movie_5,
        "Feb, 8 2023",
        "Premieres"
    ),
    Movies(
        "Avengers EndGame",
        R.drawable.movie_1,
        "Feb, 8 2023",
        "Premieres"
    ),
    Movies(
        "Avengers EndGame",
        R.drawable.movie_2,
        "Feb, 8 2023",
        "Premieres"
    ),
    Movies(
        "Avengers EndGame",
        R.drawable.movie_3,
        "Feb, 8 2023",
        "Premieres"
    )
)
