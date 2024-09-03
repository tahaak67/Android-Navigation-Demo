package com.example.democlass.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PersonDao {

    @Insert
    suspend fun addPerson(person: Person)

    @Query("select * from person")
    fun getPerson(): Flow<List<Person>>
}