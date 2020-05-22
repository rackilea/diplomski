class Card {
   private int value;
   private String suit; // Or an enum, whatever you prefer

   ... constructor/getters/setters ...
}

class Deck {
    private ArrayList<Card> cards;

    ... constructor to initialize cards ...

    public void shuffle() {
        Collections.shuffle(cards);
    }
}

public class MainGame {
    private Deck deckOne;

    public MainGame() {
        deckOne = new Deck();
        deckOne.shuffle();
    }
}