package com.example.democlass

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.room.Room
import cafe.adriel.voyager.navigator.Navigator
import com.example.democlass.data.PersonDatabase
import com.example.democlass.ui.theme.DemoClassTheme

class MainActivity : ComponentActivity() {

    companion object {
        lateinit var db: PersonDatabase
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        db = Room.databaseBuilder(applicationContext, PersonDatabase::class.java, "demo_db").build()

        setContent {
            DemoClassTheme {
                Navigator(screen = ScreenOne())
            }
        }
    }

    override fun onPause() {
        println("on pause")
        super.onPause()
    }

    override fun onResume() {
        println("Resume")
        super.onResume()
    }

    override fun onStop() {
        println("on stop")
        super.onStop()
    }

    override fun onDestroy() {
        println("on destroy")
        super.onDestroy()
    }
}

