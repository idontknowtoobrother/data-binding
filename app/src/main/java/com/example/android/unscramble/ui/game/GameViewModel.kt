package com.example.android.unscramble.ui.game

import androidx.lifecycle.ViewModel

class GameViewModel: ViewModel() {

    private var _score = 0
    private val score : Int
        get() = _score

    private var currentWordCount = 0
    private var currentScrambledWord = "test"

}