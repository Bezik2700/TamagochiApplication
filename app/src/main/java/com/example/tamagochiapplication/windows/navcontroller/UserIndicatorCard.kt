package com.example.tamagochiapplication.windows.navcontroller

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog

@Composable
fun UserIndicatorCard(
    modifier: Modifier = Modifier,
    userEatValue: MutableState<Int>,
    userHealthValue: MutableState<Int>,
    userHappinessValue: MutableState<Int>
){

    val userProgressStep by remember { mutableIntStateOf(100) }
    var indicatorCardStatus by remember { mutableStateOf(false) }

    Card (
        modifier = modifier
            .size(width = 144.dp, height = 96.dp)
            .clickable(onClick = { indicatorCardStatus = !indicatorCardStatus })
    ) {
        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxSize()
                .padding(4.dp)
        ) {
            Text("userEatStatus", fontSize = 10.sp)
            LinearProgressIndicator(
                progress = { userEatValue.value.toFloat() / userProgressStep },
                trackColor = Color.White,
                color = Color.Red
            )
            Text("userEatStatus", fontSize = 10.sp)
            LinearProgressIndicator(
                progress = { userHappinessValue.value.toFloat() / userProgressStep },
                trackColor = Color.White,
                color = Color.Green
            )
            Text("userEatStatus", fontSize = 10.sp)
            LinearProgressIndicator(
                progress = { userHealthValue.value.toFloat() / userProgressStep },
                trackColor = Color.White,
                color = Color.Blue
            )
        }
    }
    if (indicatorCardStatus) {
        Dialog(onDismissRequest = {indicatorCardStatus}) {
            Card (
                modifier = modifier
                    .fillMaxWidth()
                    .clickable(onClick = { indicatorCardStatus = !indicatorCardStatus })
            ) {
                Column (
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Text("userEatStatus", fontSize = 24.sp)
                    LinearProgressIndicator(
                        progress = { userEatValue.value.toFloat() / userProgressStep },
                        trackColor = Color.White,
                        color = Color.Red,
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    )
                    Text("userEatStatus", fontSize = 24.sp)
                    LinearProgressIndicator(
                        progress = { userHappinessValue.value.toFloat() / userProgressStep },
                        trackColor = Color.White,
                        color = Color.Green,
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    )
                    Text("userEatStatus", fontSize = 24.sp)
                    LinearProgressIndicator(
                        progress = { userHealthValue.value.toFloat() / userProgressStep },
                        trackColor = Color.White,
                        color = Color.Blue,
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    )
                }
                Column (
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Button(onClick = { indicatorCardStatus = !indicatorCardStatus }) {
                        Text("apply")
                    }
                }
            }
        }
    }
}