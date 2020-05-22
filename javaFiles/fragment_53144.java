public class Deck
{
    public static final int number = 52;

    String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
    String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};

    public Card[] deck = new Card[number];

    public void CreateDeck()
    {
        int i = 0;
        for(String suit : suits) {
            for(String rank : ranks) {
               deck[i++] = new Card(suit, rank);
            }
        }
    }
}