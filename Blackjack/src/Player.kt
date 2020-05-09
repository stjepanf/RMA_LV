abstract class Player(val deck: Deck) {
    protected val hand: Hand = Hand(
        deck.getCard(),
        deck.getCard()
    )

    abstract fun play(): Boolean
    fun score() = hand.value()

    fun hit() {
        hand.add(deck.getCard())
    }

    fun isBust(): Boolean {
        return score() > 21
    }
}

class Human(deck: Deck) : Player(deck) {
    override fun play(): Boolean {
        println("Vaš potez")
        while (true) {
            println("Vaša ruka: $hand, Zbroj: ${score()}")
            if (isBust()) {
                println("Izgubili ste.")
                return true
            }
            print("Želite li kartu ili dosta? (napišite kartu ili dosta) ")
            if (readLine()?.toLowerCase()?.trim() in listOf("kartu", "Kartu")) {
                hit()
            } else {
                return false
            }
        }
    }
}

class Dealer(deck: Deck, val humanScore: Int) : Player(deck) {
    override fun play(): Boolean {
        println("Djeliteljev potez")
        while (true) {
            if (isBust()) {
                println("Djeliteljeva ruka: $hand, Zbroj: ${score()}")
                println("Djelitelj izgubio " + score())
                return true
            }
            if (score() < 17 && score() < humanScore) {
                hit()
            } else {
                println("Djeliteljeva ruka: $hand, ZBroj: ${score()}")
                return false
            }
        }
    }

    fun showing() = hand.showing()

}


fun main(args: Array<String>) {
    println("Dobrodošli u igru Blackjack!")
    var playAgain: Boolean
    do {
        val deck = Deck()
        val human = Human(deck)
        val dealer = Dealer(deck, human.score())
        var youWin: Boolean
        println("Djelitelj pokazuje karte: " + dealer.showing())
        if (human.play()) {
            youWin = false
        } else if (dealer.play()) {
            youWin = true
        } else {
            youWin = human.score() > dealer.score()
        }
        println(if (youWin) "Pobijedili ste!" else "Djelitelj je pobijedio...")
        print("Želite li ponovo igrati? (da ili ne) ")
        playAgain = readLine()?.toLowerCase()?.trim() in listOf("da", "DA")
    } while (playAgain)
    println("Hvala na igranju!")
}