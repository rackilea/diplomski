public class Cards {
   private int[][] cards = new int[4][4];

   public void shuffle() {
      // existing shuffle method goes here - but works with private cards
   }

   public void print() {
      for (int i = 0; i < 4; i++){
        for (int j = 0; j < 4; j++){
           System.out.print(cards[i][j]);
           System.out.print(" ");
        }
      System.out.println("");
      System.out.println("");
   }
}