class Deck {
    val cards: MutableList<Card> = mutableListOf()

    init {
        for (rank in 1..13) {
            Suit.values().mapTo(cards) { Card(it, rank) }
        }
        for (i in 0 until 52) {
            val pick = (Math.random() * (52 - i) + i).toInt()
            val temp = cards[i]
            cards[i] = cards[pick]
            cards[pick] = temp
        }
    }

    fun getCard() = cards.removeAt(cards.size - 1)

    override fun toString(): String {
        return cards.map { it.toString() }
                .joinToString(separator = " ") { it }
    }
}