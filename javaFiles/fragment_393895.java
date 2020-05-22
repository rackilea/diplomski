import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Deck {

  private List<Piece> deck = new ArrayList<Piece>();
  private int taille;

  public Deck(){
    this.deck = new ArrayList<Piece>();

    for (int i = 0; i < 7; i++){
      for (int j = i; j < 7; j++){
        Domino d = new Domino(i,j);
        deck.add(d);
      }
    }

    this.taille = deck.size();
  }

  public List<? extends Piece> getDeck(){
    return this.deck;
  }

  public int tailleActuelle(){
    return this.deck.size();
  }

  public int tailleDepart(){
    return this.taille;
  }

  public void melangeDeck(){
    Collections.shuffle(deck);
  }

  public String toString(){
    return "Deck de Dominos : \nTaille de départ : "+this.tailleDepart()+
           "\nTaille actuelle : "+this.tailleActuelle();
  }

  public void printDominosDeck(){
    for (Piece d : deck){
      System.out.print(d+" ");
    }
  }
}