public class PlayingCard 
{
    private Rank rank;
    private Suit suit;

    public PlayingCard(Rank rank, Suit suit)
    {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank()
    {   
        return rank;
    }

    public Suit getSuit()
    {
        return suit;
    }

    @Override
    public String toString()
    {
        return getClass().getName() + "[rank " + rank + "suit " + suit + "]"; 
    }

    public void format()
    {
        System.out.format(rank + " of " + suit);
    }
}