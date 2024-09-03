package com.example.democlass.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow

data class ScreenTwo(val onSaveClick: (String) -> Unit) : Screen {

    @Composable
    override fun Content() {
        ScreenTwoContent(onSaveClick = onSaveClick)
    }
}

@Composable
fun ScreenTwoContent(modifier: Modifier = Modifier, onSaveClick: (String) -> Unit) {
    val navigator = LocalNavigator.currentOrThrow
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        var text by remember { mutableStateOf("") }
        Text(text = "Screen 2", fontSize = 45.sp)
        TextField(value = text, onValueChange = { text = it })
        Button(onClick = {
            onSaveClick(text)
            navigator.pop()
        }) {
            Text(text = "Go Back")
        }
    }
}
