public class StandardDeck {

    List<PlayingCard> cardArray = new ArrayList<>();

    public StandardDeck() {
       reset();
    }

    public void reset() {
        cardArray.clear();
        for(int suit = 0; suit < 4; suit++){
          for(int rank = 0; rank < 13; rank++){
            PlayingCard card = new PlayingCard(suit, rank);
            cardArray.add(card);
          }
        }
    }
}