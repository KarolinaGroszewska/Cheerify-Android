package com.example.cheerify

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface AffirmationDAO {
    @Query("SELECT * FROM affirmation_table ORDER BY text ASC")
    fun getAllAffirmations(): Flow<List<Affirmation>>

//    @Query("SELECT 1 FROM affirmation_table")
//    fun getRandomAffirmation(): Affirmation

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(text: Affirmation)

    @Query("DELETE FROM affirmation_table")
    suspend fun deleteAll()
}