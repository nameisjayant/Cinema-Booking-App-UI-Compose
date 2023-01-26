package com.programmingsimplified.cinemabookingapp.commonUi

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.programmingsimplified.cinemabookingapp.ui.theme.DarkRed

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
fun SpacerHeight(height: Dp) {
    Spacer(modifier = Modifier.height(height))
}

@Composable
fun SpacerWidth(width: Dp) {
    Spacer(modifier = Modifier.width(width))
}