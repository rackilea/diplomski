cards = new Card[SUITS][RANKS];

for(Card[] suit : cards) {
    for(int c = 0; c < RANKS; c++) {
        suit[c] = new Card(suitVar, rankVar);
    }
}