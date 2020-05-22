public class UnorderedPair<T> {
     private final Set<T> set;

     public UnorderedPair(T a, T b) {
          set = new HashSet<T>();
          set.add(a);
          set.add(b);
     }

     public boolean equals(Object b) {
         //...delegate to set
     }

     public int hashCode() {
         return set.hashCode();
     }
}