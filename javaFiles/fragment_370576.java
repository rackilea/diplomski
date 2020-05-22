import java.util.LinkedList;

public class queue<T extends Number> {

   private final LinkedList<T> linklist;
   private final int           shares;
   private final T             price;

   public queue( int shares2, T price2 ) {
      linklist = new LinkedList<>();
      shares   = shares2;
      price    = price2;
      bigAdd( shares, price );
   }

   public void add( T e ) {
      linklist.add(e);
   }

   public T take() {
      return linklist.poll();
   }

   public void bigAdd( int shares2, T price2 ) {
      while(shares2>0) {
         linklist.add(price2);
         shares2--;
      }
   }

   public double averageCost( int shares2 ) {
      double average = 0;
      int sizer = 0;
      while( sizer < shares2 ) {
         final T v = linklist.poll();
         average = average + v.doubleValue();
         sizer++;
      }
      average = average/shares2;
      return average;
   }
}