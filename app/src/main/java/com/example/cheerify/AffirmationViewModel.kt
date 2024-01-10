package com.example.cheerify

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class AffirmationViewModel(private val repository: AffirmationRepository) :ViewModel() {
    // Using LiveData and caching what allWords returns has several benefits:
    // - We can put an observer on the data (instead of polling for changes) and only update the
    //   the UI when the data actually changes.
    // - Repository is completely separated from the UI through the ViewModel.
    val allAffirmations: LiveData<List<Affirmation>> = repository.allAffirmations.asLiveData()
    fun insert(affirmation: Affirmation) = viewModelScope.launch {
        repository.insert(affirmation)
    }
}

class WordViewModelFactory(private val repository: AffirmationRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AffirmationViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return AffirmationViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}