List<Card> cardList = new ArrayList<Card>();
for (Suit suit: Suit.values()) {
  for (Rank rank: Rank.values()) { 
    cardList.add(new Card(suit, rank));
  }
}