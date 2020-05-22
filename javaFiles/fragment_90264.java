//for the changes on TPlayer see the comment on Player
public interface CardGame<TCard extends Card,TPlayer extends Player<TCard, TPlayer>> {
  //example method
  TPlayer getPlayerByName(String name);
}

//Require the implementations to register themselves as generic types
public interface Player<TCard extends Card, TPlayer extends Player<TCard, TPlayer>> {     
  List<TCard> getCards();

  CardGame<TCard, TPlayer> getGame();
}