class Deck {
  private ArrayList<Card> deck = new ArrayList<>();
  //only this class can see and work with this field

  ...
  //everyone can see and call this method
  public void addCard(Card newCard) {
    deck.add(newCard);
    gui.updateDeckValue(); //or something like that
  }
}