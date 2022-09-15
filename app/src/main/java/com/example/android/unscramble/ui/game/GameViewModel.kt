package com.example.android.unscramble.ui.game

import androidx.lifecycle.ViewModel

class GameViewModel: ViewModel() {

    private var _score = 0
    private val score : Int
        get() = _score

    private var _currentWordCount = 0
    private val currentWordCount : Int
        get() = _currentWordCount

    private var _currentScrambledWord = "test"
    private val currentScrambledWord : String
        get() = _currentScrambledWord
}