package com.gzone.luckyno7

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.MutableStateFlow

class GameViewModel : ViewModel() {
    private val deck = Deck()
    private val _dealtCards = MutableStateFlow<List<List<Card>>>(emptyList())
    val dealtCards: StateFlow<List<List<Card>>> = _dealtCards.asStateFlow()

    private val _remainingCards = MutableStateFlow(deck.remainingCards())
    val remainingCards: StateFlow<Int> = _remainingCards.asStateFlow()

    init {
        dealCards()
    }

    fun dealCards(players: Int = 4, cardsPerPlayer: Int = 5) {
        deck.reset()
        _dealtCards.value = deck.dealToPlayers(players, cardsPerPlayer)
        _remainingCards.value = deck.remainingCards()
    }
}