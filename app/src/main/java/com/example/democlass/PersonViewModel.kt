package com.example.democlass

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.democlass.data.Person
import kotlinx.coroutines.launch

class PersonViewModel : ViewModel() {

    var personsList by mutableStateOf(emptyList<Person>())

    init {
        viewModelScope.launch {
            MainActivity.db.dao().getPerson().collect {
                personsList = it
            }
        }
    }

    fun addPerson(name: String) {
        viewModelScope.launch {
            MainActivity.db.dao().addPerson(Person(name = name))
        }

    }
}