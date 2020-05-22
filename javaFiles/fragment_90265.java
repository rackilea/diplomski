class BananaPlayer implements Player<BananaCard, BananaPlayer> {
  public List<BananaCard> getCards() { /*snip*/ }

  public CardGame<BananaCard, BananaPlayer> getGame() { /*snip*/ } 
}

class BananaGame implements CardGame<BananaCard, BananaPlayer> {
  public BananaPlayer getPlayerByName( String pName ) { /*snip*/ }    
}