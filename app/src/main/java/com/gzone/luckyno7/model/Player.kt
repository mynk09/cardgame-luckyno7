package com.gzone.luckyno7.model

import com.gzone.luckyno7.Card

data class Player(
    val id: Int,
    val name: String,
    val hand: MutableList<Card>,
    val discardPile: MutableList<Card> = mutableListOf()
) {
    fun calculateScore(): Int {
        return hand.sumOf { it.getGameValue() }
    }

    fun discard(cardsToDiscard: List<Card>) {
        hand.removeAll(cardsToDiscard)
        discardPile.addAll(cardsToDiscard)
    }

    fun drawCard(card: Card) {
        hand.add(card)
    }
}
