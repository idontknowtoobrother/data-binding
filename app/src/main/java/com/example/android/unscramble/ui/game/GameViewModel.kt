package com.example.android.unscramble.ui.game

import android.util.Log
import androidx.lifecycle.ViewModel

class GameViewModel: ViewModel() {

    private val TAG = "GameViewModel"


    private var _score = 0
    val score : Int
        get() = _score

    private var _currentWordCount = 0
    val currentWordCount : Int
        get() = _currentWordCount

    private lateinit var _currentScrambledWord: String
    val currentScrambledWord : String
        get() = _currentScrambledWord

    private var wordList: MutableList<String> = mutableListOf()
    private lateinit var _currentWord: String

    init {
        Log.d(TAG, "${TAG} created!")
        getNextWord()
    }

    fun nextWord(): Boolean {
        return  if (currentWordCount < MAX_NO_OF_WORDS){
            getNextWord()
            true
        } else false
    }

    private fun getNextWord() {
        _currentWord = allWordsList.random()
        val tempWord = _currentWord.toCharArray()
        tempWord.shuffle()

        while (String(tempWord).equals(_currentWord, false)) {
            tempWord.shuffle()
        }
        if (wordList.contains(_currentWord)) {
            getNextWord()
        } else {
            _currentScrambledWord = String(tempWord)
            ++_currentWordCount
            wordList.add(_currentWord)
        }
    }


    fun reinitializeData() {
        _score = 0
        _currentWordCount = 0
        wordList.clear()
        getNextWord()

    }

    fun isUserWordCorrect(playerWord : String): Boolean {
        if(playerWord.equals(_currentWord)) {
            increaseScore()
            return true
        }
        return false
    }

    private fun increaseScore() {
        _score += SCORE_INCREASE

    }

    override fun onCleared() {
        super.onCleared()
        Log.d(TAG, "${TAG} destroyed!")
    }
}