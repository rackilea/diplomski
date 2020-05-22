public class Deck 
{
    public Card hoax06;

    static Deck createDeck()
    {
        Deck deck = new Deck();
        deck.hoax06 = new Card("Nirwadas the Traveler", "hoax06", 3, 2);
        return deck;
    }
}

public class Game 
{
    public static void main(String[] args) 
    {
        Deck deck = Deck.createDeck();
        System.out.println(deck.hoax06.name); // this is where the error occurs
    }
}