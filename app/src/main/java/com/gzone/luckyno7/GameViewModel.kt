package com.gzone.luckyno7

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.gzone.luckyno7.model.Player

class GameViewModel : ViewModel() {

    private val deck = Deck().apply { shuffle() }

    private val _players = mutableStateListOf<Player>()
    val players: List<Player> get() = _players

    private val _currentPlayerIndex = mutableStateOf(0)
    val currentPlayerIndex: State<Int> get() = _currentPlayerIndex

    private val _round = mutableStateOf(1)
    val round: State<Int> get() = _round

    private val _gameEnded = mutableStateOf(false)
    val gameEnded: State<Boolean> get() = _gameEnded

    private val _winner = mutableStateOf<Player?>(null)
    val winner: State<Player?> get() = _winner

    init {
        initializePlayers()
    }

    private fun initializePlayers() {
        _players.clear()
        deck.reset()
        deck.shuffle()

        repeat(4) { i ->
            val playerHand = mutableListOf<Card>()
            repeat(5) {
                deck.drawCard()?.let { playerHand.add(it) }
            }
            _players.add(Player(id = i, name = "Player ${i + 1}", hand = playerHand))
        }
    }

    fun discardAndDraw(
        playerIndex: Int,
        cardsToDiscard: List<Card>,
        fromDeck: Boolean
    ) {
        val player = _players[playerIndex]
        player.discard(cardsToDiscard)

        val drawCard = if (fromDeck) {
            deck.drawCard()
        } else {
            val prevPlayer = _players[(playerIndex + _players.size - 1) % _players.size]
            prevPlayer.discardPile.lastOrNull()
        }

        drawCard?.let { player.drawCard(it) }

        _currentPlayerIndex.value = (_currentPlayerIndex.value + 1) % _players.size
        if (_currentPlayerIndex.value == 0) {
            _round.value += 1
        }
    }

    fun callCheck(callerIndex: Int) {
        val caller = _players[callerIndex]
        val callerScore = caller.calculateScore()

        val otherScores = _players.filter { it.id != callerIndex }
            .map { it.calculateScore() }

        val lowestOtherScore = otherScores.minOrNull() ?: Int.MAX_VALUE

        _gameEnded.value = true

        _winner.value = if (callerScore < lowestOtherScore) {
            caller
        } else {
            _players.minByOrNull { it.calculateScore() }
        }
    }

    fun resetGame() {
        _gameEnded.value = false
        _winner.value = null
        _round.value = 1
        _currentPlayerIndex.value = 0
        initializePlayers()
    }

    fun getDeckSize(): Int = deck.cardsLeft()
    fun peekTopCard(): Card? {
        return deck.peekTop()
    }
}
