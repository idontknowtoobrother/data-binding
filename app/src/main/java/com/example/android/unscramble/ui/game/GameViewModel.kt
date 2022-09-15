package com.example.android.unscramble.ui.game

import android.util.Log
import androidx.lifecycle.ViewModel

class GameViewModel: ViewModel() {

    private val TAG = "GameViewModel"
    init {
        Log.d(TAG, "${TAG} created!")
    }

    private var _score = 0
    val score : Int
        get() = _score

    private var _currentWordCount = 0
    val currentWordCount : Int
        get() = _currentWordCount

    private var _currentScrambledWord = "test"
    val currentScrambledWord : String
        get() = _currentScrambledWord

    override fun onCleared() {
        super.onCleared()
        Log.d(TAG, "${TAG} destroyed!")
    }
}