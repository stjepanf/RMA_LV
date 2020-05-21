package com.example.inspiringperson

object Person {

    public val pers : MutableList<InspiringPerson>


    init {
        pers = retrievePerson()
    }
    private fun retrievePerson(): MutableList<InspiringPerson> {
        return mutableListOf(
            InspiringPerson("Steve Jobs",R.drawable.jobs,"Steve Jobs je bio izvršni direktor, biznismen i dizajner tvrtke Apple Inc., čiji je suosnivač. Bio je jedan je od najutjecajnijih ljudi u svijetu računalne industrije. Neki od poznatijih proizvoda tvrke Apple u čijem je razvijanju sudjelovao su iPhone, iPad, iPod i Mac.","24. veljače 1955. - 5. listopada 2011"),
            InspiringPerson("Nikola Tesla",R.drawable.tesla,"Nikola Tesla bio je hrvatski i američki elektroinženjer i izumitelj podrijetlom Srbin iz Hrvatske. Rođen u Lici, ali je gotovo cijeli život radio u SAD-u, gdje je i ostvario sve izume. Gimnaziju je pohađao u Gospiću, potom u Rakovcu kraj Karlovca, gdje je maturirao","10. srpnja 1856. - 7. siječnja 1943."),
            InspiringPerson("Mate Rimac",R.drawable.rimac,"Mate Rimac, hrvatski je inovator, poduzetnik te osnivač i direktor tvrtki Rimac Automobili i Greyp Bikes."," 1988."),
            InspiringPerson("Stephen Hawking",R.drawable.hawking,"Stephen William Hawking, bio je britanski teoretski fizičar. Završio je studij fizike na Sveučilištu Oxford, a doktorsku disertaciju iz kozmologije obranio na Sveučilištu Cambridge. Već 1974. godine postao je član Kraljevskog društva iz Londona, jednog od najstarijih znanstvenih udruženja na svijetu."," 8. siječnja 1942")


        )

    }



}