import java.util.Arrays;

public final class Selector {

  private Selector() {
  } 

  public static <T> T nearest(Collection<T> c, T val, Telemeter<T> tm) {
      if (c == null || c.isEmpty()) {
         throw new IllegalArgumentException("a is null or has zero-length");
      }
      int idx = 0;
      double distance = tm.distance(c.get(0), val);
      for (int i = 1; i < c.size(); i++) {
         double cdistance = tm.distance(c.get(i), val);
         if (cdistance <= distance) {
            idx = i;
            distance = cdistance;
         }
      }
      int theNumber = c.get(idx);
      return theNumber;
   }

}