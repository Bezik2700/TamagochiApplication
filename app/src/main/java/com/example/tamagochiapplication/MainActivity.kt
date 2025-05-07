package com.example.tamagochiapplication

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.rememberNavController
import com.example.tamagochiapplication.settings.DataStoreManager
import com.example.tamagochiapplication.settings.UserSettingActivity
import com.example.tamagochiapplication.ui.theme.TamagochiApplicationTheme
import com.example.tamagochiapplication.windows.navcontroller.NavController

class MainActivity : ComponentActivity() {

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val dataStoreManager = DataStoreManager(this)

        setContent {
            TamagochiApplicationTheme {

                val userName = remember { mutableStateOf("") }
                val userEatValue = remember { mutableIntStateOf(0) }
                val userHealthValue = remember { mutableIntStateOf(0) }
                val userHappinessValue = remember { mutableIntStateOf(0) }
                val appMenuState = remember { mutableStateOf(false) }
                val settingCardStatus = remember { mutableStateOf(false) }
                val shoppingCardStatus = remember { mutableStateOf(false) }
                val silverPoint = remember { mutableIntStateOf(0) }
                val goldPoint = remember { mutableIntStateOf(0) }
                val keyPoint = remember { mutableIntStateOf(0) }

                LaunchedEffect(key1 = true) {
                    dataStoreManager.getSettings().collect { settings ->
                        userName.value = settings.userName
                        userHealthValue.intValue = settings.userHealthValue
                        userEatValue.intValue = settings.userHealthValue
                        userHappinessValue.intValue = settings.userHappinessValue
                        appMenuState.value = settings.appMenuState
                        shoppingCardStatus.value = settings.shoppingCardStatus
                        settingCardStatus.value = settings.settingCardStatus
                        silverPoint.intValue = settings.silverPoint
                        goldPoint.intValue = settings.goldPoint
                        keyPoint.intValue = settings.keyPoint
                    }
                }

                UserSettingActivity()
                /*NavController(
                    navController = rememberNavController(),
                    userHealthValue = userHealthValue,
                    userHappinessValue = userHappinessValue,
                    userEatValue = userEatValue,
                    appMenuState = appMenuState,
                    userName = userName,
                    dataStoreManager = dataStoreManager,
                    shoppingCardStatus = shoppingCardStatus,
                    settingCardStatus = settingCardStatus,
                    goldPoint = goldPoint,
                    silverPoint = silverPoint,
                    keyPoint = keyPoint
                )*/
            }
        }
    }
}