// for Deck
@Override 
public String toString() {
   StringBuilder sb = new StringBuilder();
   for (Card card: cards) {
      sb.append(card.toString() + ", ");
   }
   return sb.toString();
}