package com.gzone.luckyno7

import kotlin.random.Random

class Deck {
    private val cards = mutableListOf<Card>()

    init {
        reset()
    }

    fun reset() {
        cards.clear()
        // Create all 52 cards
        Suit.values().forEach { suit ->
            Value.values().forEach { value ->
                cards.add(Card(suit, value))
            }
        }
        shuffle()
    }

    fun shuffle() {
        cards.shuffle(Random(System.currentTimeMillis()))
    }

    fun dealToPlayers(playerCount: Int, cardsPerPlayer: Int): List<List<Card>> {
        if (playerCount * cardsPerPlayer > cards.size) {
            throw IllegalArgumentException("Not enough cards in deck")
        }

        val hands = List(playerCount) { mutableListOf<Card>() }

        // Deal cards in standard fashion (one to each player in turn)
        repeat(cardsPerPlayer) {
            for (hand in hands) {
                hand.add(cards.removeAt(0))
            }
        }

        return hands
    }

    fun remainingCards(): Int = cards.size
}