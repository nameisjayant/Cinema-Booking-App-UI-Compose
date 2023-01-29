package com.programmingsimplified.cinemabookingapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.programmingsimplified.cinemabookingapp.R
import com.programmingsimplified.cinemabookingapp.commonUi.SpacerHeight
import com.programmingsimplified.cinemabookingapp.ui.theme.*


@Composable
fun FoodScreen() {

    var search by remember { mutableStateOf("") }


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
            }
        }
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