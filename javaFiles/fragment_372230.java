import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// This is just sample example  and it is just to show an approach. I had not enough time    to make code perfect but it works fine.
public enum Deck
{
DECK;
enum Rank
{
    DEUCE(2), THREE(3), FOUR(4), FIVE(5), SIX(6),
    SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(10), QUEEN(10), KING(10), ACE(11);

    Rank(int rank)
    {
        this.rank = rank;
    }

    private final int rank;

}

enum Type
{
    SPADES,
    HEARTS,
    DIAMONDS,
    CLUBS;
}

class Card
{
    private final Rank rank;
    private final Type type;

    Card(Rank rank, Type type)
    {
        this.rank = rank;
        this.type = type;
    }

    @Override
    public String toString()
    {
        return type.name() + rank.name();
    }

}

static List<Deck.Card> cards = new ArrayList<Deck.Card>();
static
{
    for (Rank rank : Deck.Rank.values())
    {
        for (Type type : Deck.Type.values())
        {
            cards.add(DECK.new Card(rank, type));
        }
    }

}

List<Deck.Card> shuffle()
{
    Collections.shuffle(cards);
    System.out.println(cards);
    System.out.println(cards.size());
    return Collections.unmodifiableList(cards);
}

public static void main(String[] args)
{
    DECK.shuffle();
}
}