package com.example.android.unscramble.ui.game

import android.util.Log
import androidx.lifecycle.ViewModel
import java.sql.Struct

class GameViewModel: ViewModel() {

    private val TAG = "GameViewModel"
    init {
        Log.d(TAG, "${TAG} created!")
        getNextWord()
    }

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

    fun nextWord(): Boolean {
        return  if (currentWordCount < MAX_NO_OF_WORDS){
            getNextWord()
            true
        } else false
    }

    private fun getNextWord()  {
        _currentWord = wordList.random()
        val tempWord = _currentWord.toCharArray()
        tempWord.shuffle()
        while (String(tempWord).equals(_currentWord, false)) {
            tempWord.shuffle()
        }

        if(wordList.contains(_currentWord)){
            return getNextWord()
        }

        _currentScrambledWord = String(tempWord)
        ++_currentWordCount
        wordList.add(_currentWord)
    }



    override fun onCleared() {
        super.onCleared()
        Log.d(TAG, "${TAG} destroyed!")
    }
}