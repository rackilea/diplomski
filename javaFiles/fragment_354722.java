// create the deck
Integer[] deck = new Integer[52];
for (int i = 0; i < deck.length; i++) {
    deck[i] = i;
}

// shuffle it
Collections.shuffle(Arrays.asList(deck));