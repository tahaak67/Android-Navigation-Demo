package com.example.democlass.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Person::class],
    version = 1
)
abstract class PersonDatabase : RoomDatabase() {
    abstract fun dao(): PersonDao
}

