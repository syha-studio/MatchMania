package com.example.matchmania

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HighscoreViewModel : ViewModel() {

    private val _highscores = MutableLiveData<List<HighscoreItem>>()
    val highscores: LiveData<List<HighscoreItem>> get() = _highscores

    init {
        // Inisialisasi data highscores dengan sample data
        _highscores.value = generateSampleHighscores()
    }

    // Fungsi untuk mengatur data highscores
    fun setHighscores(highscoresList: List<HighscoreItem>) {
        _highscores.value = highscoresList
    }

    private fun generateSampleHighscores(): List<HighscoreItem> {
        val highscoreList = mutableListOf<HighscoreItem>()
        for (i in 1..10) {
            highscoreList.add(HighscoreItem("Player $i", (10 - i) * 1000))
        }
        return highscoreList
    }
}
