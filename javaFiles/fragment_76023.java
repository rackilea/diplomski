public class Card {
    public enum CardType {
        ONE,
        TWO,
        THREE;
    }

    public enum Suit {
            HEARTS,
            CLUBS,
    }

    private CardType cardType;
    private Suit suit;

    constructor && getters (...)
}



public class Deck {
    List<Card> cards = new ArrayList<Card>();
    public void init() {
        for(CardType cardType : CardType.values()) {
            for(Suit suit : Suit.values()) {
                  cards.add(new Card(cardType, suit));
            }
        }
        Collections.shuffle(cards);
    }
}