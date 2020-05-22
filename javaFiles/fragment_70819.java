public class Deck {

    private Card[] cards;

    public Deck() {

        int numberOfRanks = 13;
        int numberOfSuits = 4;
        int numberOfCards = numberOfRanks * numberOfSuits;

        Rank[] rank = Rank.values();
        Suit[] suit = Suit.values();

        cards = new Card[numberOfCards];

        for (int i = 0; i < numberOfRanks; i++) {
            for (int j = 0; j < numberOfSuits; j++) {

                cards[i * numberOfSuits + j] = new Card(rank[i], suit[j]);
            }
        }
    }

    public void shuffleCards() {

        Random rand = new Random();
        counter = 0;

        for (int c = rand.nextInt(6) + 5; c > 0; c--) {
            for (int i = cards.length - 1; i > 0; i--) {

                int index = rand.nextInt(i + 1);
                Card card = cards[index];
                cards[index] = cards[i];
                cards[i] = card;
            }
        }
    }

    private int counter = 0;

    public void dealCards() {

        try{
        for (int i = 0; i < 5; i++) {
            counter++;
            System.out.println(cards[counter]);
            if (counter == 50) {
                System.out.println("Almost all cards have been used, please reshuffle.");
                // Either return 1 card or an array of 5 cards.
            }
        } 
        } catch (ArrayIndexOutOfBoundsException aioobe){
            System.out.println("Caught an ArrayIndexOutOfBoundsException. Reshuffling deck.");
            shuffleCards();
        }
    }

    @Override
    public String toString() {

        String deckOfCards = "";

        for (Card c : cards) {

            deckOfCards += c.toString() + "\n";

        }

        return deckOfCards;

    }
}