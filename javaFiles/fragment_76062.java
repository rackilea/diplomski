public class Cards {
   private int width;
   private int length;
   private int[][] cards;

   public void shuffle() {
      // existing shuffle method goes here - but works with private cards
   }

   public void print() {
      for (int i = 0; i < length; i++){
        for (int j = 0; j < width; j++){
           System.out.print(cards[i][j]);
           System.out.print(" ");
        }
      System.out.println("");
      System.out.println("");
   }
}