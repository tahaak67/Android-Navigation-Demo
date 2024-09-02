package com.example.democlass

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow

data class ScreenTwo(val name: String) : Screen {

    @Composable
    override fun Content() {
        ScreenTwoContent(name = name)
    }
}

@Composable
fun ScreenTwoContent(modifier: Modifier = Modifier, name: String) {
    val navigator = LocalNavigator.currentOrThrow
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Screen 2", fontSize = 45.sp)
        Text(text = "Hello $name", fontSize = 45.sp)
        Button(onClick = { navigator.pop() }) {
            Text(text = "Go Back")
        }
    }
}
