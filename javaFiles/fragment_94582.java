public enum Suite {
    HEARTS, SPADES, CLUBS, DIAMONDS;
}

public enum Value {
    ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE;
}

public class Card
{
    private final Suite suite;
    private final Value value;

    public Card(final Suite suite, final Value value)
    {
        this.suite = suite;
        this.value = value;
    }

    @Override
    public boolean equals(final Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final Card other = (Card) obj;
        if (suite != other.suite)
        {
            return false;
        }
        if (value != other.value)
        {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((suite == null) ? 0 : suite.hashCode());
        result = prime * result + ((value == null) ? 0 : value.hashCode());
        return result;
    }

    @Override
    public String toString()
    {
        return "[" + value + " of " + suite + "]";
    }
}

public class Deck
{
    public static void main(final String[] args)
    {
        final Deck deck = new Deck();
        for (int i = 0; i < 5; i++)
        {
            System.out.println(deck.deal());
        }
    }

    List<Card> cards = new ArrayList<Card>();

    public Deck()
    {
        // initialise
        for (final Suite suite : Suite.values())
        {
            for (final Value value : Value.values())
            {
                final Card card = new Card(suite, value);
                cards.add(card);
            }
        }
    }

    public Card deal()
    {
        final Random random = new Random(System.nanoTime());
        if (cards.size() > 0)
        {
            return cards.remove(random.nextInt(cards.size()));
        }
        else
        {
            return null;
        }
    }

    @Override
    public String toString()
    {
        return cards.toString();
    }
}