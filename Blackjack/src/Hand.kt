class Hand(card1: Card, card2: Card) {
    private val cards: MutableList<Card> = mutableListOf()
    private var aces = 0

    fun showing() = cards[1]

    init {
        add(card1)
        add(card2)
    }

    fun add(card: Card): Hand {
        if (card.rank == 1) {
            aces++
        }
        cards.add(card)
        return this
    }

    fun value(): Int {
        var aces = aces
        var score = cards.map { it.rank }
            .reduce { acc, i ->
                acc + when (i) {
                    1 -> 11
                    in 10..13 -> 10
                    else -> i
                }
            }
        while (score > 21 && aces > 0) {
            score -= 10
            aces--
        }
        return score
    }

    override fun toString(): String {
        return cards.map { it.toString() }
            .joinToString(separator = " ") { it }
    }
}