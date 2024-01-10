package com.example.cheerify

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "affirmation_table")
class Affirmation(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "text") val text: String,
    @ColumnInfo(name = "isCustom") val isCustom: Boolean,
    @ColumnInfo(name = "isFavorite") val isFavorite: Boolean,

    )