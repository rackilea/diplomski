for (Char suit : new Char[]{'C', 'D', 'H', 'S'}) {
  for (Card card : cards) {
     if(card.getSuit() == suit)
        hand.append(card + "  ");
  }
  hand.append("\n");
}