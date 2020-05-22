import java.util.*;


public class Main
{

    public static void main(String[] args)
    {
        List<Card> deck = new ArrayList<Card>();
        deck.add(new Card(1));
        deck.add(new Card(3));
        deck.add(new Card(7));
        deck.add(new Card(10));

        Random randomGenerator = new Random(); 

        System.out.println("Deck 1 tests");
        // draw 3 cards:
        for (int i = 0; i < 3; i++)
        {
            int randomCard = randomGenerator.nextInt(deck.size());
            Card card = deck.remove(randomCard);
            System.out.println("Removed a(n) "+card);
        }

        // you could also do
        List<Card> deck2 = new ArrayList<Card>();
        deck2.add(new Card(1));
        deck2.add(new Card(7));
        deck2.add(new Card(3));
        deck2.add(new Card(10));

        Collections.shuffle(deck2);
        System.out.println("Deck 2 tests");
        // draw 3 cards:
        for (int i = 0; i < 3; i++)
        {
            Card card = deck2.remove(0);
            System.out.println("Removed a(n) "+card);
        }


    }

}

class Card {
    public Card(int i)
    {
        blackJackValue = i;
    }

    public int blackJackValue;

    public String toString() {
        return String.valueOf(blackJackValue);
    }
}