package com.programmingsimplified.cinemabookingapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.programmingsimplified.cinemabookingapp.commonUi.Header
import com.programmingsimplified.cinemabookingapp.commonUi.SpacerHeight
import com.programmingsimplified.cinemabookingapp.data.Movies
import com.programmingsimplified.cinemabookingapp.data.moviesList
import com.programmingsimplified.cinemabookingapp.ui.theme.DarkRed
import com.programmingsimplified.cinemabookingapp.ui.theme.GradientBackground
import com.programmingsimplified.cinemabookingapp.ui.theme.InterFont

@Composable
fun ComingSoonScreen() {

    Box(
        modifier = Modifier.padding(bottom = 60.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(GradientBackground)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 20.dp, end = 20.dp, top = 40.dp)
            ) {
                Header()
                LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                    items(moviesList) {
                        ComingSoonMovieRow(it)
                    }
                }
            }
        }
    }

}

@Composable
fun ComingSoonMovieRow(
    movies: Movies
) {

    Column(
        modifier = Modifier.padding(
            top = 20.dp, end = 20.dp,
        ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = movies.poster), contentDescription = "",
            modifier = Modifier
                .width(154.dp)
                .height(220.dp)
                .clip(RoundedCornerShape(20.dp)),
            contentScale = ContentScale.Crop
        )
        SpacerHeight(height = 5.dp)
        Text(
            text = movies.movieName,
            style = TextStyle(
                color = DarkRed,
                fontWeight = FontWeight.W700,
                fontSize = 18.sp,
                fontFamily = InterFont
            ),
            textAlign = TextAlign.Center,
            modifier = Modifier.width(140.dp)
        )

    }

}