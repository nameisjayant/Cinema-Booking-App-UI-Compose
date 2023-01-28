package com.programmingsimplified.cinemabookingapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.programmingsimplified.cinemabookingapp.bottom_bar.BottomBarRoutes
import com.programmingsimplified.cinemabookingapp.screens.BillBoardScreen
import com.programmingsimplified.cinemabookingapp.screens.ComingSoonScreen
import com.programmingsimplified.cinemabookingapp.screens.FoodScreen
import com.programmingsimplified.cinemabookingapp.screens.ProfileScreen


@Composable
fun MainNavigation(
    navHostController: NavHostController
) {

    NavHost(navController = navHostController, startDestination = BottomBarRoutes.Billboard.route) {
        composable(BottomBarRoutes.Billboard.route) {
            BillBoardScreen()
        }
        composable(BottomBarRoutes.ComingSoon.route) {
            ComingSoonScreen()
        }
        composable(BottomBarRoutes.Food.route) {
            FoodScreen()
        }
        composable(BottomBarRoutes.Profile.route) {
            ProfileScreen()
        }
    }

}