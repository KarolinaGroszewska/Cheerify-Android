package com.example.cheerify

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Affirmation::class), version = 1, exportSchema = false)
public abstract class AffirmationRoomDatabase : RoomDatabase() {
    abstract fun affirmationDAO() : AffirmationDAO

    companion object {
        @Volatile
        private var INSTANCE: AffirmationRoomDatabase? = null

        fun getDatabase(context: Context): AffirmationRoomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AffirmationRoomDatabase::class.java,
                    "affirmation_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}