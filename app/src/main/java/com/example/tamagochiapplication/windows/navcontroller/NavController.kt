package com.example.tamagochiapplication.windows.navcontroller

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.tamagochiapplication.windows.EntertainmentsScreen
import com.example.tamagochiapplication.windows.HobbyScreen
import com.example.tamagochiapplication.windows.MainScreen
import com.example.tamagochiapplication.windows.SettingScreen
import com.example.tamagochiapplication.windows.WorkScreen

sealed class Screens(val route: String){
    data object MainScreen: Screens("MainScreen")
    data object SettingScreen: Screens("SettingScreen")
    data object HobbyScreen: Screens("HobbyScreen")
    data object EntertainmentScreen: Screens("EntertainmentScreen")
    data object WorkScreens: Screens("WorkScreen")
}

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun NavController(
    navController: NavHostController,
    userEatValue: MutableState<Int>,
    userHealthValue: MutableState<Int>,
    userHappinessValue: MutableState<Int>,
    appMenuState: MutableState<Boolean>
){
    Scaffold(
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary,
            ) {
                AppBottomBar(
                    navController = navController,
                    appMenuState = appMenuState
                )
            }
        },
    ) { innerPadding ->
        NavHost(
            modifier = Modifier.padding(innerPadding),
            navController = navController,
            startDestination = Screens.MainScreen.route,
            enterTransition = { slideInHorizontally(initialOffsetX = { 15000 }) + fadeIn() },
            exitTransition = { slideOutHorizontally(targetOffsetX = { -15000 }) + fadeOut() }
        ) {
            composable (route = Screens.MainScreen.route) {
                MainScreen(
                    navController = navController
                )
            }
            composable (route = Screens.SettingScreen.route) {
                SettingScreen(
                    navController = navController
                )
            }
            composable (route = Screens.HobbyScreen.route) {
                HobbyScreen(
                    navController = navController
                )
            }
            composable (route = Screens.WorkScreens.route) {
                WorkScreen(
                    navController = navController
                )
            }
            composable (route = Screens.EntertainmentScreen.route) {
                EntertainmentsScreen(
                    navController = navController
                )
            }
        }
        NavControllerContent(
            userEatValue = userEatValue,
            userHealthValue = userHealthValue,
            userHappinessValue = userHappinessValue,
            appMenuState = appMenuState
        )
        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.End,
            modifier = Modifier.fillMaxSize()
        ) {
            Text("Test indicator value")
            Button(onClick = { userEatValue.value ++ }) {
                Text(userEatValue.value.toString())
            }
            Button(onClick = { userHappinessValue.value ++ }) {
                Text(userHappinessValue.value.toString())
            }
            Button(onClick = { userHealthValue.value ++ }) {
                Text(userHealthValue.value.toString())
            }
        }
    }
}