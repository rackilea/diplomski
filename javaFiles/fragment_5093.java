public Pack() {
   int i = 0;
   for (Rank r : Rank.values()) {
      for (Suit s : Suit.values()) {
         cards[i] = new PlayingCard(r, s);
         i++;
      }
   }
}