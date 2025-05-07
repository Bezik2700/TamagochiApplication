package com.example.tamagochiapplication.windows.navcontroller

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tamagochiapplication.R
import com.example.tamagochiapplication.windows.menu.SettingScreen

@Composable
fun NavControllerContent(
    navController: NavController,
    userEatValue: MutableState <Int>,
    userHealthValue: MutableState <Int>,
    userHappinessValue: MutableState <Int>,
    appMenuState: MutableState <Boolean>,
    settingCardStatus: MutableState <Boolean>,
    shoppingCardStatus: MutableState <Boolean>,
    silverPoint: MutableState <Int>,
    goldPoint: MutableState <Int>,
    keyPoint: MutableState <Int>,
    modifier: Modifier = Modifier
){
    val scope = rememberCoroutineScope()

    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        Image(
            painterResource(R.drawable.ic_launcher_foreground),
            contentDescription = null
        )
    }
    Row (
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.2f)
            .padding(top = 80.dp, start = 16.dp, end = 16.dp)
    ) {
        UserMoneyCard(
            silverPoint = silverPoint,
            goldPoint = goldPoint,
            keyPoint = keyPoint
        )
        Text("userNameText", modifier.align(Alignment.Bottom))
        UserIndicatorCard(
            userEatValue = userEatValue,
            userHealthValue = userHealthValue,
            userHappinessValue = userHappinessValue
        )
    }
    if (appMenuState.value) {
        Column(
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.End,
            modifier = Modifier.fillMaxSize().padding(bottom = 144.dp, end = 16.dp)
        ) {
            IconButton(
                onClick = { settingCardStatus.value = !settingCardStatus.value }
            ) {
                Icon(
                    Icons.Rounded.Settings,
                    contentDescription = null
                )
            }
            IconButton(
                onClick = { shoppingCardStatus.value = !shoppingCardStatus.value }
            ) {
                Icon(
                    Icons.Rounded.ShoppingCart,
                    contentDescription = null
                )
            }
        }
    }
}