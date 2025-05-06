package com.example.tamagochiapplication.windows.navcontroller

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun UserMoneyCard(modifier: Modifier = Modifier){
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        Card (
            modifier = modifier.size(width = 144.dp, height = 80.dp),
        ) {
            Column {
                Text("moneyValue: 0" , modifier.padding(4.dp))
                Text("moneyValueGold: 0" , modifier.padding(4.dp))
            }
        }
    }
}