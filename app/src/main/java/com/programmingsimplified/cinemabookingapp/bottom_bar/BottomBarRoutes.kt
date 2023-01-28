package com.programmingsimplified.cinemabookingapp.bottom_bar

import com.programmingsimplified.cinemabookingapp.R

sealed class BottomBarRoutes(
    val route: String,
    val title: String,
    val icon: Int,
    val icon_focused: Int
) {


    object Billboard: BottomBarRoutes(
        route = "billboard",
        title = "Billboard",
        icon = R.drawable.billboard,
        icon_focused = R.drawable.billboard
    )

    object ComingSoon: BottomBarRoutes(
        route = "coming soon",
        title = "Coming soon",
        icon = R.drawable.coming_soon,
        icon_focused = R.drawable.coming_soon
    )

    object Food: BottomBarRoutes(
        route = "food",
        title = "Food",
        icon = R.drawable.food,
        icon_focused = R.drawable.food
    )

    object Profile: BottomBarRoutes(
        route = "profile",
        title = "Profile",
        icon = R.drawable.profile,
        icon_focused = R.drawable.profile
    )

}