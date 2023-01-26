package com.programmingsimplified.cinemabookingapp.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.SpaceBetween
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.programmingsimplified.cinemabookingapp.commonUi.CommonIconButtonCard
import com.programmingsimplified.cinemabookingapp.ui.theme.GradientBackground
import  com.programmingsimplified.cinemabookingapp.R
import com.programmingsimplified.cinemabookingapp.commonUi.SpacerWidth
import com.programmingsimplified.cinemabookingapp.ui.theme.DarkRed
import com.programmingsimplified.cinemabookingapp.ui.theme.InterFont
import com.programmingsimplified.cinemabookingapp.ui.theme.LightGray

@Composable
fun BillBoardScreen() {

    val options = listOf("Services", "Theaters")
    var selected by remember { mutableStateOf("Services") }

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
            Promotions()
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = SpaceBetween
            ) {
                options.forEach {
                    SelectOptions(title = it, selected = it == selected) {
                        selected = it
                    }

                }
            }

        }

    }

}

@Composable
fun Promotions() {

    val buildString = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = Color.White,
                fontFamily = InterFont,
                fontSize = 20.53.sp,
                fontWeight = FontWeight.W300
            )
        ) {
            append("Know the\npromotions of\n")
        }
        withStyle(
            style = SpanStyle(
                color = Color.White,
                fontFamily = InterFont,
                fontSize = 20.53.sp,
                fontWeight = FontWeight.W800
            )
        ) {
            append("Tuesdays & Monday")
        }
    }

    Card(
        shape = RoundedCornerShape(20.dp),
        backgroundColor = Color.Transparent,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(LightGray), contentAlignment = Center
        ) {
            Row(
                modifier = Modifier.padding(vertical = 10.dp)
            ) {
                Text(
                    text = buildString
                )
                SpacerWidth(width = 15.dp)
                CommonIconButtonCard(
                    icon = R.drawable.arrow_right_down,
                    iconSize = 50.dp,
                    modifier = Modifier.size(74.dp)
                )
            }
        }
    }
}

@Composable
fun SelectOptions(
    title: String,
    selected: Boolean,
    onValueChange: (String) -> Unit
) {

    Card(
        shape = RoundedCornerShape(18.27.dp),
        backgroundColor = Color.Transparent,
        border = if (selected) BorderStroke(2.74.dp, DarkRed) else
            BorderStroke(
                0.dp,
                Color.Transparent
            ),
        modifier = Modifier
            .width(155.dp)
            .height(56.dp)
    ) {
        Box(
            modifier = Modifier
                .background(LightGray)
                .clickable { onValueChange(title) },
            contentAlignment = Center
        ) {
            Text(
                text = title,
                style = TextStyle(
                    color = if (selected) DarkRed else Color.White,
                    fontSize = if (selected) 22.67.sp else 21.55.sp,
                    fontWeight = if (selected) FontWeight.W700 else FontWeight.W300,
                    fontFamily = InterFont
                )
            )
        }
    }

}


@Composable
fun ChooseCinema() {

    Card(
        shape = RoundedCornerShape(10.dp),
        backgroundColor = Color.Transparent
    ) {
        Box(modifier = Modifier.background(LightGray), contentAlignment = Center) {
            Row(
                modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp)
            ) {
                Column {
                    Text(
                        text = "Choose Cinema",
                        style = TextStyle(
                            color = DarkRed,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.W900,
                            fontFamily = InterFont
                        )
                    )
                    Text(
                        text = "Medellín",
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 17.sp,
                            fontWeight = FontWeight.W300,
                            fontFamily = InterFont
                        )
                    )
                }
                IconButton(
                    onClick = { }, modifier = Modifier
                        .size(24.dp)
                        .align(CenterVertically)
                ) {
                    Icon(
                        imageVector = Icons.Rounded.ArrowDropDown,
                        contentDescription = "",
                        tint = DarkRed
                    )
                }
            }
        }
    }

}

@Composable
fun Header() {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        ChooseCinema()
        Row(
            modifier = Modifier.align(CenterVertically)
        ) {
            CommonIconButtonCard(icon = R.drawable.search)
            SpacerWidth(width = 5.dp)
            Icon(
                painter = painterResource(id = R.drawable.person), contentDescription = "",
                tint = Color.Unspecified, modifier = Modifier.size(50.dp)
            )
        }
    }
}