package com.gzone.luckyno7

enum class Suit(val symbol: String) {
    SPADES("♠"),
    HEARTS("♥"),
    DIAMONDS("♦"),
    CLUBS("♣")
}

enum class Value(val display: String) {
    ACE("A"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    TEN("10"),
    JACK("J"),
    QUEEN("Q"),
    KING("K")
}

data class Card(val suit: Suit, val value: Value) {
    fun imageName(): String {
        val suitName = suit.name.lowercase()
        val valueName = when (value) {
            Value.ACE -> "ace"
            Value.JACK -> "jack"
            Value.QUEEN -> "queen"
            Value.KING -> "king"
            else -> value.display
        }
        return "card_${valueName}_$suitName"
    }

    fun getGameValue(): Int {
        return when (value) {
            Value.ACE -> 1
            Value.TWO -> 2
            Value.THREE -> 3
            Value.FOUR -> 4
            Value.FIVE -> 5
            Value.SIX -> 6
            Value.SEVEN -> 0 // Lucky No. 7 rule
            Value.EIGHT -> 8
            Value.NINE -> 9
            Value.TEN -> 10
            Value.JACK -> 11
            Value.QUEEN -> 12
            Value.KING -> 13
        }
    }
}
