package com.example.tamagochiapplication.windows.navcontroller

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun UserIndicatorCard(
    modifier: Modifier = Modifier,
    userEatValue: MutableState<Int>,
    userHealthValue: MutableState<Int>,
    userHappinessValue: MutableState<Int>
){
    Card (
        modifier = modifier.size(width = 144.dp, height = 96.dp)
    ) {
        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.fillMaxSize().padding(4.dp)
        ) {
            Text("userEatStatus", fontSize = 10.sp)
            LinearProgressIndicator(
                progress = { userEatValue.value.toFloat() },
                trackColor = Color.White,
                color = Color.Red
            )
            Text("userEatStatus", fontSize = 10.sp)
            LinearProgressIndicator(
                progress = { userHappinessValue.value.toFloat() },
                trackColor = Color.White,
                color = Color.Green
            )
            Text("userEatStatus", fontSize = 10.sp)
            LinearProgressIndicator(
                progress = { userHealthValue.value.toFloat() },
                trackColor = Color.White,
                color = Color.Blue
            )
        }
    }
}