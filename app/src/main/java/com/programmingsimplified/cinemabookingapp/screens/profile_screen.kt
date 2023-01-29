package com.programmingsimplified.cinemabookingapp.screens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.Center
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
import com.programmingsimplified.cinemabookingapp.commonUi.CommonIconButtonCard
import com.programmingsimplified.cinemabookingapp.commonUi.SpacerWidth
import com.programmingsimplified.cinemabookingapp.ui.theme.*


@Composable
fun ProfileScreen() {


    Box(
        modifier = Modifier.padding(bottom = 60.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(DarkBlack)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ProfileHeader()
                ProfilePic()
                Column(
                    modifier = Modifier.padding(vertical = 30.dp)
                ) {
                    ProfileOptions(
                        icon = R.drawable.ticket,
                        title = stringResource(R.string.my_ticket)
                    ) {

                    }
                    ProfileOptions(
                        icon = R.drawable.credit_card,
                        title = stringResource(R.string.my_credit_card)
                    ) {

                    }
                    ProfileOptions(
                        icon = R.drawable.history,
                        title = stringResource(R.string.history)
                    ) {

                    }
                }
                Column() {
                    EditOptions(
                        icon = R.drawable.change_city,
                        title = stringResource(R.string.change_city)
                    ) {

                    }
                    EditOptions(
                        icon = R.drawable.about,
                        title = stringResource(R.string.about_us)
                    ) {

                    }
                }
            }
            LogoutButton(
                modifier = Modifier
                    .align(BottomCenter)
                    .padding(horizontal = 40.dp, vertical = 10.dp)
            )
        }
    }

}

@Composable
fun ProfileOptions(
    @DrawableRes icon: Int,
    title: String,
    onClick: () -> Unit
) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 40.dp, vertical = 5.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(
                LightGray
            )
            .clickable { onClick() }

    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row {
                Icon(
                    painter = painterResource(id = icon), contentDescription = "",
                    modifier = Modifier
                        .size(25.dp)
                        .align(CenterVertically),
                    tint = Color.Unspecified,

                    )
                SpacerWidth(20.dp)
                Text(
                    text = title, style = TextStyle(
                        color = Color.White,
                        fontFamily = InterFont,
                        fontSize = 21.sp,
                        fontWeight = FontWeight.W500
                    )
                )
            }
            IconButton(
                onClick = { }, modifier = Modifier
                    .size(25.dp)
                    .align(CenterVertically)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.arrow_right),
                    contentDescription = "",
                    tint = Color.Unspecified
                )
            }
        }

    }

}

@Composable
fun EditOptions(
    @DrawableRes icon: Int,
    title: String,
    onClick: () -> Unit
) {

    Row(
        modifier = Modifier
            .padding(bottom = 15.dp)
            .clickable { onClick() }
    ) {
        Icon(
            painter = painterResource(id = icon), contentDescription = "",
            modifier = Modifier.size(30.dp),
            tint = Color.Unspecified
        )
        SpacerWidth(10.dp)
        Text(
            text = title, style = TextStyle(
                color = Color.White,
                fontFamily = InterFont,
                fontSize = 21.sp,
                fontWeight = FontWeight.W300
            ),
            modifier = Modifier.align(CenterVertically)
        )
    }

}

@Composable
fun LogoutButton(
    modifier: Modifier = Modifier,
    backgroundColor: Color = DarkRed
) {
    Button(
        onClick = {},
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = backgroundColor
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 5.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                painter = painterResource(id = R.drawable.logout), contentDescription = "",
                tint = Color.Unspecified,
                modifier = Modifier.size(24.dp)
            )
            Text(
                text = stringResource(R.string.logout), style = TextStyle(
                    color = Color.White,
                    fontFamily = InterFont,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.W800
                ),
                modifier = Modifier.align(CenterVertically)
            )
            Box {}
        }
    }
}

@Composable
fun ProfilePic() {
    Row(
        modifier = Modifier
            .padding(vertical = 20.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.person), contentDescription = "",
            tint = Color.Unspecified, modifier = Modifier.size(105.dp)
        )
        Column(
            modifier = Modifier
                .padding(start = 20.dp)
                .align(CenterVertically)
        ) {
            Text(
                text = stringResource(R.string.hi),
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.W500,
                    fontFamily = InterFont,
                    color = Color.White
                ),
            )
            Text(
                text = stringResource(R.string.welcome),
                style = TextStyle(
                    fontSize = 27.sp,
                    fontWeight = FontWeight.W800,
                    fontFamily = InterFont,
                    color = Color.White
                ),
            )
        }
    }
}

@Composable
fun ProfileHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Box {}
        Text(
            text = stringResource(R.string.profile), style = TextStyle(
                fontSize = 27.sp,
                fontWeight = FontWeight.W800,
                fontFamily = InterFont,
                color = Color.White
            ),
            modifier = Modifier.align(Alignment.CenterVertically)
        )
        CommonIconButtonCard(icon = R.drawable.setting)
    }
}

