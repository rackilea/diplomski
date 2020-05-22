public class GenRandom {

   int []  cards = new int [GameFrame.NUMBER_OF_CARDS];

   public void generateCards() {
      for (int i = 0; i < cards.length; i++) { // for each index of the array...
         int card; // declare card
         do {
            card = (int) (Math.random() * 51) + 1; // random between 1 and 52
         } while (contains(card)); // regenerate random card if array already contains.
         cards[i] = card; // card is unique, so assign value to array index
      }
   }

   private boolean contains(int t){
      for(int i = 0; i < GameFrame.NUMBER_OF_CARDS; i++){ // for each index...
         if(cards[i] == t){
            return true; // if the generated card is already in the array..
         }
      }
      return false; // otherwise reached end, so return false.
   }

   public int [] getAllCards() {
      return cards;
   }
}