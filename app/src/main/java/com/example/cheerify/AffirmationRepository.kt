package com.example.cheerify

import android.support.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class AffirmationRepository(private val affirmationDAO: AffirmationDAO) {
    // Room executes all queries on a separate thread.
    // Observed Flow will notify the observer when the data has changed.
    val allAffirmations: Flow<List<Affirmation>> = affirmationDAO.getAllAffirmations()

    // By default Room runs suspend queries off the main thread, therefore, we don't need to
    // implement anything else to ensure we're not doing long running database work
    // off the main thread.
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(affirmation: Affirmation){
        affirmationDAO.insert(affirmation)
    }
}