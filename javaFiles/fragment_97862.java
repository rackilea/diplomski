import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortPairs {

    public static void main(String[] args) {
        List<Double> rank = new ArrayList<Double>(Arrays.asList(1.0, 2.0, 3.1, 1.2, 2.1)); 
        List<Double> cd = new ArrayList<Double>(Arrays.asList(6.2, 5.2, 7.1, 8.0, 1.1));

        List<Pair<Double, Double>> pairs = new ArrayList<Pair<Double, Double>>(rank.size());
        for (int i = 0; i < rank.size(); ++i)
            pairs.add(new Pair<Double, Double>(rank.get(i), cd.get(i)));

        Collections.sort(pairs);

        ListIterator<Double> rankIter = rank.listIterator();
        ListIterator<Double> cdIter = cd.listIterator();
        for (Pair<Double, Double> pair : pairs) {
            System.out.println(String.format("[rank = %.1f, cd = %.1f", pair.getT1(), pair.getT2()));
            rankIter.next();
            cdIter.next();
            rankIter.set(pair.getT1());
            cdIter.set(pair.getT2());
        }
    }

   public static class Pair <T1 extends Comparable<? super T1>, T2 extends Comparable<? super T2>> implements Comparable<Pair<T1, T2>> {
      private final T1 t1;
      private final T2 t2;

      public Pair(T1 t1, T2 t2) {
         this.t1 = t1;
         this.t2 = t2;
      }

      public T1 getT1() {
          return t1;
      }

      public T2 getT2() {
          return t2;
      }

      @Override
      public int compareTo(Pair<T1, T2> other) {
          return t1.equals(other.t1) ?
                 other.t2.compareTo(t2) : 
                 other.t1.compareTo(t1);
      }
   }
}