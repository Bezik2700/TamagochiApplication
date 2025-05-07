package com.example.tamagochiapplication.windows.menu

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Dialog
import com.example.tamagochiapplication.settings.DataStoreManager
import com.example.tamagochiapplication.settings.SettingData
import kotlinx.coroutines.launch

@Composable
fun SettingScreen(
    dataStoreManager: DataStoreManager,
    userEatValue: MutableState <Int>,
    userHealthValue: MutableState <Int>,
    userHappinessValue: MutableState <Int>,
    appMenuState: MutableState <Boolean>,
    settingCardStatus: MutableState <Boolean>,
    shoppingCardStatus: MutableState <Boolean>,
    silverPoint: MutableState <Int>,
    goldPoint: MutableState <Int>,
    keyPoint: MutableState <Int>,
    userName: MutableState<String>
){

    val scope = rememberCoroutineScope()

    Dialog(onDismissRequest = {settingCardStatus.value}) {
        Card {
            Column (
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Enter your name")
                TextField(value = userName.value, onValueChange = {userName.value = it})
                Button(onClick = {
                    settingCardStatus.value = !settingCardStatus.value
                    scope.launch {
                        dataStoreManager.saveSettings(
                            SettingData(
                                userName = userName.value,
                                userEatValue = userEatValue.value,
                                userHealthValue = userHealthValue.value,
                                userHappinessValue = userHappinessValue.value,
                                appMenuState = appMenuState.value,
                                shoppingCardStatus = shoppingCardStatus.value,
                                settingCardStatus = !settingCardStatus.value,
                                silverPoint = silverPoint.value,
                                goldPoint = goldPoint.value,
                                keyPoint = keyPoint.value
                            )
                        )
                    }
                }) {
                    Text("Close")
                }
            }
        }
    }
}