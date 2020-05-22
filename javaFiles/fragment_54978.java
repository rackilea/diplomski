private List<Card> deck = new ArrayList();

//you don't need class Deck anymore

deck.add(new Card("Clovers","Jack",11)); // to add
deck.remove(new Card("Clovers","Jack",11)); // to remove
System.out.println(deck.size()); // to print n. of cards

// to display
for (Card c: deck){
    System.out.println(c);
}