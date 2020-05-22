class Deck {
    private int numberOfCards = 52;
    private Card[] cards;

    private String[] suits = { "Clubs", "Diamonds", "Hearts", "Spades" };
    String[] ranks = { "Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen",
            "King" };
    int[] values = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10 };

    private String rank;
    private int value;

    public Deck() // This creates a deck of 52 playing cards.
    {
        cards = new Card[numberOfCards];
        int currentCardId = 0;
        for (int suit = 0; suit <= 3; suit++) {
            for (int rank = 0; rank <= 12; rank++) {
                this.rank = "" + ranks[rank];
                this.value = values[rank];

                cards[currentCardId] = new Card(suits[suit], this.rank, value);
                System.out.println(cards[currentCardId].toString()); //print out the cards .toString() as it was added to the array
                currentCardId++;
            }
        }
    }
}