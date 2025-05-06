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

                LaunchedEffect(key1 = true) {
                    dataStoreManager.getSettings().collect { settings ->
                        userName.value = settings.userName
                        userHealthValue.intValue = settings.userHealthValue
                        userEatValue.intValue = settings.userHealthValue
                        userHappinessValue.intValue = settings.userHappinessValue
                        appMenuState.value = settings.appMenuState
                    }
                }

                NavController(
                    navController = rememberNavController(),
                    userHealthValue = userHealthValue,
                    userHappinessValue = userHappinessValue,
                    userEatValue = userEatValue,
                    appMenuState = appMenuState
                )
            }
        }
    }
}