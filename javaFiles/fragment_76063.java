public class Cards {
    private int width;
    private int length;
    private int[][] cards;

   public Cards(int length, int width) {
      this.length = length;
      this.width = width;
      this.cards = new int[length][width];
   }

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