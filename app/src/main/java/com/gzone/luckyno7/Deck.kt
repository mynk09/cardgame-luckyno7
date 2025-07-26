package com.gzone.luckyno7

import kotlin.random.Random

class Deck {
    private val cards = mutableListOf<Card>()

    init {
        reset()
    }

    /** Resets the deck to a full set of 52 cards and shuffles it */
    fun reset() {
        cards.clear()
        Suit.values().forEach { suit ->
            Value.values().forEach { value ->
                cards.add(Card(suit, value))
            }
        }
        shuffle()
    }

    /** Shuffles the deck using a time-based seed */
    fun shuffle() {
        cards.shuffle(Random(System.currentTimeMillis()))
    }

    /** Deals cards to players in a round-robin fashion */
    fun dealToPlayers(playerCount: Int, cardsPerPlayer: Int): List<List<Card>> {
        if (playerCount * cardsPerPlayer > cards.size) {
            throw IllegalArgumentException("Not enough cards in deck")
        }

        val hands = List(playerCount) { mutableListOf<Card>() }

        repeat(cardsPerPlayer) {
            for (hand in hands) {
                hand.add(cards.removeAt(0))
            }
        }

        return hands
    }

    /** Draws the top card from the deck */
    fun drawCard(): Card? {
        return if (cards.isNotEmpty()) cards.removeAt(0) else null
    }

    /** Returns the number of cards left in the deck */
    fun remainingCards(): Int = cards.size

    /** Alias for remainingCards */
    fun cardsLeft(): Int = remainingCards()
    fun peekTop(): Card? = cards.lastOrNull()
}
