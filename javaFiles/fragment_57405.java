List<Hand> hands = new ArrayList<Hand>(players); // defines each players hand (in your case one, each "cards" cards);

// let 'em draw
for(int k=0; k<players; ++k) {
    Hand currentHand = new Hand();
    for(int i=0; i<cards; ++i) {
       currentHand.add(deck.drawFromDeck());
    }
    hands.add(currentHand);
}

// find the best
Collections.sort(hands); // make sure to implement Comparable, to reasonably check which one has the best hand

for(int i=0; i<players; ++i) {
    System.out.println("Player " + (i+1) + ": " + hands.get(i)); // Make sure Hand::toString() is overriden properly
}