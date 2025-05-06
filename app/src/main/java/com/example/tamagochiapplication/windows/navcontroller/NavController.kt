package com.example.tamagochiapplication.windows.navcontroller

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AddCircle
import androidx.compose.material.icons.rounded.ArrowDropDown
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material.icons.rounded.Warning
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.tamagochiapplication.R
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
            userHappinessValue = userHealthValue,
            appMenuState = appMenuState
        )
    }
}