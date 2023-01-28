package com.programmingsimplified.cinemabookingapp.commonUi

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.programmingsimplified.cinemabookingapp.R
import com.programmingsimplified.cinemabookingapp.ui.theme.DarkRed
import com.programmingsimplified.cinemabookingapp.ui.theme.InterFont
import com.programmingsimplified.cinemabookingapp.ui.theme.LightGray

@SuppressLint("ModifierParameter")
@Composable
fun CommonIconButtonCard(
    @DrawableRes icon: Int,
    tint: Color = Color.Unspecified,
    iconSize: Dp = 24.dp,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {

    Card(
        shape = RoundedCornerShape(12.9.dp),
        modifier = modifier.size(50.dp)
    ) {
        Box(
            modifier = Modifier
                .background(DarkRed)
                .clickable { onClick() },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = icon), contentDescription = "",
                tint = tint, modifier = Modifier.size(iconSize)
            )
        }
    }

}

@Composable
fun SpacerHeight(height: Dp=10.dp) {
    Spacer(modifier = Modifier.height(height))
}

@Composable
fun SpacerWidth(width: Dp=10.dp) {
    Spacer(modifier = Modifier.width(width))
}

@Composable
fun Header() {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        ChooseCinema()
        Row(
            modifier = Modifier.align(Alignment.CenterVertically)
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


@Composable
fun ChooseCinema() {

    Card(
        shape = RoundedCornerShape(10.dp),
        backgroundColor = Color.Transparent
    ) {
        Box(modifier = Modifier.background(LightGray), contentAlignment = Alignment.Center) {
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
                        .align(Alignment.CenterVertically)
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
