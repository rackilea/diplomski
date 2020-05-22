/**
 * Adds a card to the deck.
 *
 * @param the card to add.
 * @throws IllegalArgumentException if the card is null.
 */
public void addCard(final Card card) 
{
    if(card == null)
    {
        throw new IllegalArgumentException("card must not be null");
    }

    cardList.add(card);
}