package com.example.tamagochiapplication.windows.menu

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Dialog

@Composable
fun ShoppingScreen(shoppingCardStatus: MutableState <Boolean>){
    Dialog(onDismissRequest = {shoppingCardStatus.value}) {
        Card {
            Column (
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("This is ShoppingDialog Dialog")
                Button(onClick = {shoppingCardStatus.value = !shoppingCardStatus.value}) {
                    Text("Close")
                }
            }
        }
    }
}