data class Card(val suit: Suit, val rank: Int) {
    override fun toString(): String {
        return when (rank) {
            1 -> "AS"
            13 -> "K"
          11-> "J"
           12 -> "Q"
            else -> rank.toString()
        } + when (suit) {
            Suit.TREF -> "TREF"
            Suit.KARO -> "KARO"
            Suit.SRCE -> "SRCE"
            Suit.PIK -> "PIK"
        }
    }
}