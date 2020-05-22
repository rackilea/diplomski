public void fill() {
  int i = 0;
  for (Suit s : Suit.values()) {
    for (Rank r : Rank.values()) {
      cards[i]= new Card(r,s);
      i++;  // increment i here
    }
  }
}