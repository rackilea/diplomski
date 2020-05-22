public class Addition implements Calculation {

     private final int x;
     private final int y;

     public Addition(int x, int y) {
         this.x = x;
         this.y = y;
     }

     @Override
     public int calculate(){
         return x + y;
     }
 }