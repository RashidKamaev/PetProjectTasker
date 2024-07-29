package com.example.tasker.button.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun BottomNavigation(function: Any, function1: Any) {
    TODO("Not yet implemented")
}


@Composable
fun ButtomNavigation(
    navController: navController
) {
    val listItems = ListOf(
        ButtonItem.Screen1,
        ButtonItem.Screen2,
        ButtonItem.Screen3
    )
    androidx.compose.material3.BottomNavigation( {
        var backgroundColor = Color.White
        ) {
        val backStackEntry by navController.currentBackStackEntryAsState()
    }
}

@Composable
fun BottomNavigation(content: @Composable Any) {
    TODO("Not yet implemented")
}
}
