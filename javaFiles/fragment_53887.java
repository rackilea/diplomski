List<Card> deck = new ArrayList<>();
for (suit : Suit.values) {
    for (num = 1 to 13) {
        deck.add(new Card(suit, num));
    }
}
// now you have a deck of 52 cards

// shuffle the decek
Collections.shuffle(deck);

// take first 20 card from deck, by whatever way you like