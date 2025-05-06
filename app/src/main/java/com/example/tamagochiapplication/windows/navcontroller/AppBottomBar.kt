package com.example.tamagochiapplication.windows.navcontroller

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AddCircle
import androidx.compose.material.icons.rounded.ArrowDropDown
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun AppBottomBar(
    modifier: Modifier = Modifier,
    navController: NavController,
    appMenuState: MutableState<Boolean>
){
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp)
    ) {
        IconButton(
            onClick = { navController.navigate(Screens.HobbyScreen.route) }
        ) {
            Icon(
                Icons.Rounded.Close,
                contentDescription = null
            )
        }
        VerticalDivider(modifier.padding(top = 2.dp, bottom = 2.dp))
        IconButton(
            onClick = {navController.navigate(Screens.WorkScreens.route)}
        ) {
            Icon(
                Icons.Rounded.Warning,
                contentDescription = null
            )
        }
        VerticalDivider(modifier.padding(top = 2.dp, bottom = 2.dp))
        IconButton(
            onClick = {navController.navigate(Screens.MainScreen.route)}
        ) {
            Icon(
                Icons.Rounded.Home,
                contentDescription = null,
                modifier.size(80.dp)
            )
        }
        VerticalDivider(modifier.padding(top = 2.dp, bottom = 2.dp))
        IconButton(
            onClick = {navController.navigate(Screens.EntertainmentScreen.route)}
        ) {
            Icon(
                Icons.Rounded.AddCircle,
                contentDescription = null
            )
        }
        VerticalDivider(modifier.padding(top = 2.dp, bottom = 2.dp))
        IconButton(
            onClick = { appMenuState.value = !appMenuState.value }
        ) {
            if (appMenuState.value){
                Icon(
                    Icons.Rounded.ArrowDropDown,
                    contentDescription = null
                )
            } else {
                Icon(
                    Icons.Rounded.Menu,
                    contentDescription = null
                )
            }
        }
    }
}