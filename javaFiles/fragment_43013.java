public enum Suit {
    HEARTS
    ,SPADES
    ,DIAMONDS
    ,CLUBS
}

public class Card {
    private final int cardValue;
    private final Suit suit;
    private boolean faceUp;

    public Card(int value, Suit suit) {
         this.cardValue = value;
         this.faceUp = false;
         this.suit = suit;
    }
    // ...snip...
    public Suit getSuit() {
        return this.suit;
    }
}