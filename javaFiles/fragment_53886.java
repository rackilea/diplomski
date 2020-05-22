enum Suit {
    SPADE, HEART, DIAMOND, CLUB
}

class Card {
    private Suit suit;
    private int number;  // 1 = Ace... 13 = King
    Card(Suit suit, int number) {....}

    // Getters, toString(), equals(), hashCode()
    // no setters, as this is good candidate for immutable class
}