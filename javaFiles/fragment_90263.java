public interface Card {}

public interface CardGame<TCard extends Card,TPlayer extends Player<TCard>> {
 //example method
 TPlayer getPlayerByName(String name);
}

public interface Player<TCard extends Card> {     
 List<TCard> getCards();
}