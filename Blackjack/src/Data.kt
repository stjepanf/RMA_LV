

fun main() {
  println(Hand(Card(Suit.TREF, 3), Card(Suit.KARO, 5))
      .add(Card(Suit.PIK, 12)))
  println(Deck())
}