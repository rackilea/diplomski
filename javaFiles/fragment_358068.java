ArrayList<Card> deck = new ArrayList<Card>();
// Do whatever you do with your deck :P

ListIterator<Card> li = deck.listIterator(deck.size());

// Iterate in reverse.
while(li.hasPrevious()) 
{
  Card card = li.previous();
  // Do stuff with the card
}