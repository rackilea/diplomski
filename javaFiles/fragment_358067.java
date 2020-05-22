private static class DeckIterator implements Iterator<Card>
{

private int nextCard;
private final List<Card> cards;

public DeckIterator(List<Card> cards)
{
    this.cards = cards;
    this.nextCard = cards.size() - 1;
}

@Override
public boolean hasNext()
{
    if (nextCard < 0)
        return false;
    return true;
}

/**
 * {@inheritDoc}
 */
@Override
public Card next()
{
    if (hasNext())
        return cards.get(nextCard--);
    return null;
}

/**
 * {@inheritDoc}
 */
@Override
public void remove()
{

}
}