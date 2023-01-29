package com.programmingsimplified.cinemabookingapp.data

import androidx.annotation.DrawableRes
import com.programmingsimplified.cinemabookingapp.R

data class Food(
    val id:Int,
    val title:String,
    @DrawableRes val image:Int,
    val price:String
)

val foodList = listOf(
    Food(1,"PopCorn 2x1",R.drawable.popcorn,"$3,99"),
    Food(2,"Burger and fries",R.drawable.burger,"$7,99"),
    Food(3,"Chicken wings",R.drawable.chicken,"$60,99"),
    Food(4,"PopCorn 2x1",R.drawable.popcorn,"$3,99")
)