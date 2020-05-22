private ArrayList<Card> deck = new ArrayList<Card>();
private final int HANDSIZE = 5;

private static Deck deck = new Deck();

public static Deck getInstance() {
  return deck;
}

// Private Constructor
private Deck() {

    for(Suit suit : Suit.values()) {
        for(Value value : Value.values()){
            Card card = new Card(value, suit);
            deck.add(card);
        }
    }
}

public ArrayList<Card> draw() {

    Random rng = new Random();
    ArrayList<Card> hand = new ArrayList<Card>();
    for(int i = 0; i < HANDSIZE; i++){
    int getCard = rng.nextInt(deck.size());
    Card addCard = deck.get(getCard);
    hand.add(addCard);
    deck.remove(getCard);
    }

    return hand;
}