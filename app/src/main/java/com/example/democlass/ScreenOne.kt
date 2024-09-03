package com.example.democlass

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import kotlin.random.Random

class ScreenOne(): Screen {

    @Composable
    override fun Content() {
        ScreenOneContent() // <- screen content here
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenOneContent(modifier: Modifier = Modifier) {
    val navigator = LocalNavigator.currentOrThrow
    val viewModel: PersonViewModel = viewModel()
    Scaffold(
        topBar = { TopAppBar(title = { Text("Database Example") }) },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                viewModel.addPerson("person: ${Random.nextInt()}")
            }) {
                Text("Add")
            }
        },
    ) { paddingValues ->
        LazyColumn(
            modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(viewModel.personsList) { person ->
                Text(person.name, fontSize = 30.sp)
            }
        }
    }

}
