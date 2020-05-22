public class Deck {

   public static int nRanks = 13;  
   public static int nSuits = 4; 
   public static int nCard = nRanks * nSuits; 

   Card[] deck = new Card[nCard]; //nCard indexes, not nCard - 1

   public Deck() {
      //remove the while, double loop useless
      for(int i = 0; i < nRanks; i++){
         for(int j = 0; j < nSuits; j++){
            deck[j * nRanks + i] = new Card(i,j);
         }
      }
   }

   public Card getCard(int x){
      return deck[x-1];   
   }
}