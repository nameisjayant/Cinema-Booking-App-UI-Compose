package com.programmingsimplified.cinemabookingapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.programmingsimplified.cinemabookingapp.bottom_bar.BottomBar
import com.programmingsimplified.cinemabookingapp.navigation.MainNavigation
import com.programmingsimplified.cinemabookingapp.screens.BillBoardScreen
import com.programmingsimplified.cinemabookingapp.ui.theme.CinemaBookingAppTheme
import com.programmingsimplified.cinemabookingapp.ui.theme.GradientBackground

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CinemaBookingAppTheme {
                val navHostController = rememberNavController()
                Surface{
                    Scaffold(
                        bottomBar = {
                           BottomBar(navController = navHostController)
                        }
                    ) {
                        MainNavigation(navHostController = navHostController)
                    }
                }
            }
        }
    }
}
