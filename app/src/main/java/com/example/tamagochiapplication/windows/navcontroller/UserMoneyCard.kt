package com.example.tamagochiapplication.windows.navcontroller

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun UserMoneyCard(
    modifier: Modifier = Modifier,
    silverPoint: MutableState <Int>,
    goldPoint: MutableState <Int>,
    keyPoint: MutableState <Int>,
){

    var moneyCardStatus by remember { mutableStateOf(false) }

    Card (
        modifier = modifier
            .size(width = 144.dp, height = 96.dp)
            .clickable(onClick = {moneyCardStatus = !moneyCardStatus}),
    ) {
        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Text("silver: ${silverPoint.value}")
            Text("gold: ${goldPoint.value}")
            Text("gold: ${keyPoint.value}")
        }
    }
    if (moneyCardStatus){
        Dialog(onDismissRequest = {moneyCardStatus}) {
            Card(
                modifier = modifier
                    .fillMaxWidth()
                    .clickable(onClick = { moneyCardStatus = !moneyCardStatus })
            ) {
                Column (
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier.fillMaxWidth().padding(8.dp)
                ) {
                    Text("silver: ${silverPoint.value}")
                    Text("gold: ${goldPoint.value}")
                    Text("gold: ${keyPoint.value}")
                }
                Column (
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Button(onClick = {moneyCardStatus = !moneyCardStatus}) {
                        Text("apply")
                    }
                }
            }
        }
    }
}