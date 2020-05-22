Card[][] cards = new Card[4][13];
for (int i = 0; i < suits.length; i++) {
    for (int j = 0; j < 13; j++) {
        cards[i][j] = new Card(j + 1, suits[i]);
    }
}