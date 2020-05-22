public class MyClass {

   public static class MyIterator<T> {
      Iterator<T> defaultIterator;

      public MyIterator(Iterator<T> defaultIterator) {
         this.defaultIterator = defaultIterator;
      }

      public T getNext() {
         try {
            if (defaultIterator.hasNext()) {
               return defaultIterator.next();
            }
         } catch (Exception e) {
            // Fall through
         }
         return null;
      }
   }

   public static void Main(String[] args) {
      TreeSet<Integer> list = new TreeSet<>();

      MyIterator<Integer> myIterator = new MyIterator<>(list.iterator());

      while (myIterator.getNext() != null) {
         // do stuff
      }
   }
}