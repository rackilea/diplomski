String rank, suit;    
static String[] ranks = {"2","3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
static String[] suits = {"Spades","Hearts", "Clubs", "Diamonds"};
static Card[] deck = new Card[52];

public Card(String rank, String suit)
{
    this.rank = rank;
    this.suit = suit;
}