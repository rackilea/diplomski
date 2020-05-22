import java.util.Iterator;
import java.util.Iterable;

class Foo implements Iterable<Integer> {
   public final int x;

   public Foo(int x) {
      this.x = x;
   }

   public Iterator<Integer> iterate() {
      return new Iterator<Integer> {
         int i = 0;

         public boolean hasNext() {
            return i < 10;
         }

         public Integer next() {
            return x * (i ++);
         }
      };
   }
}
...
for (int x : new Foo(5)) {
   System.out.println(x);
}