package com.programmingsimplified.cinemabookingapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.programmingsimplified.cinemabookingapp.R
import com.programmingsimplified.cinemabookingapp.commonUi.CommonIconButtonCard
import com.programmingsimplified.cinemabookingapp.commonUi.SpacerHeight
import com.programmingsimplified.cinemabookingapp.commonUi.SpacerWidth
import com.programmingsimplified.cinemabookingapp.data.Food
import com.programmingsimplified.cinemabookingapp.data.foodList
import com.programmingsimplified.cinemabookingapp.ui.theme.*


@Composable
fun FoodScreen() {

    var search by remember { mutableStateOf("") }
    val menuList = listOf("Promotion", "Drinks", "Fast food")
    val scrollState = rememberScrollState()
    var currentMenuState by remember { mutableStateOf("Promotion") }

    Box(
        modifier = Modifier.padding(bottom = 60.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(DarkBlack)
        ) {
            Column {
                FoodHeader()
                FoodMenu(text = search, onValueChange = { search = it })
                Row(modifier = Modifier.padding(start = 30.dp)) {
                    menuList.forEach {
                        CustomFoodChip(title = it, selected = it == currentMenuState) {
                            currentMenuState = it
                        }
                    }
                }
                LazyColumn {
                    items(foodList, key = { it.id }) {
                        ShowFood(food = it)
                    }
                    item { SpacerHeight() }
                }
            }

        }
    }
}

@Composable
fun ShowFood(
    food: Food
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = 15.dp, end = 30.dp, start = 30.dp
            ).clip(RoundedCornerShape(13.dp))
            .background(LightGray)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = food.image), contentDescription = "",
                modifier = Modifier
                    .width(150.dp)
                    .fillMaxHeight()
                    .weight(0.5f)
            )
            Column(
                modifier = Modifier.padding(15.dp)
            ) {
                Text(
                    text = food.title, style = TextStyle(
                        fontSize = 23.sp,
                        fontWeight = FontWeight.W800,
                        color = DarkRed,
                        fontFamily = InterFont
                    )
                )
                SpacerHeight()
                Row {
                    Text(
                        text = food.price, style = TextStyle(
                            fontSize = 23.sp,
                            fontWeight = FontWeight.W300,
                            color = Color.White,
                            fontFamily = InterFont
                        )
                    )
                    SpacerWidth()
                    TextButton(
                        onClick = { },
                        shape = RoundedCornerShape(4.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color.White
                        ),
                        elevation = ButtonDefaults.elevation(0.dp),
                        modifier = Modifier
                            .size(26.dp)
                            .align(CenterVertically)
                    ) {
                        Icon(Icons.Default.Add, contentDescription = "", tint = Color.Black)
                    }
                }
            }
        }
    }
}


@Composable
fun CustomFoodChip(
    title: String,
    selected: Boolean,
    onValueChange: (String) -> Unit
) {
    TextButton(
        onClick = {
            onValueChange(title)
        },
        elevation = ButtonDefaults.elevation(0.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = if (selected) DarkRed else LightGray
        ),
        shape = RoundedCornerShape(40.dp),
        modifier = Modifier.padding(end = 10.dp)
    ) {
        Text(
            text = title, style = TextStyle(
                color = Color.White,
                fontFamily = InterFont,
                fontSize = 13.sp,
                fontWeight = FontWeight.W500
            )
        )
    }
}

@Composable
fun FoodMenu(
    text: String,
    onValueChange: (String) -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .padding(vertical = 20.dp, horizontal = 30.dp)
    ) {
        Text(
            text = stringResource(R.string.menu),
            style = TextStyle(
                fontSize = 27.sp,
                fontWeight = FontWeight.W800,
                fontFamily = InterFont,
                color = Color.White
            ),
        )
        SpacerHeight(20.dp)
        CustomSearchView(text = text, onValueChange = { onValueChange(it) })
    }

}

@Composable
fun CustomSearchView(
    text: String,
    onValueChange: (String) -> Unit
) {
    Box(modifier = Modifier.clip(RoundedCornerShape(10.dp))) {
        TextField(
            value = text, onValueChange = {
                onValueChange(it)
            },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = LightGray,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                placeholderColor = DarkGray,
                textColor = Color.White
            ),
            placeholder = {
                Text(
                    text = stringResource(id = R.string.search),
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.W400,
                        fontFamily = InterFont
                    )
                )
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.search), contentDescription = "",
                    tint = Color.White
                )
            },
            trailingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.microphone), contentDescription = "",
                    tint = Color.White
                )
            }
        )
    }
}

@Composable
fun FoodHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Box {}
        Text(
            text = stringResource(R.string.FOOD), style = TextStyle(
                fontSize = 27.sp,
                fontWeight = FontWeight.W800,
                fontFamily = InterFont,
                color = Color.White
            ),
            modifier = Modifier.align(CenterVertically)
        )
        IconButton(onClick = {}, modifier = Modifier.size(48.dp)) {
            Icon(
                painter = painterResource(id = com.programmingsimplified.cinemabookingapp.R.drawable.notification),
                contentDescription = "",
                tint = Color.Unspecified
            )
        }
    }
}