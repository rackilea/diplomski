public class MyClass {
   public static interface Listener {
      public void onNotify();
   }

   private List<Listener> listeners = new ArrayList<Listener>();

   // addListener and removeListener methods omitted.

   public void doSomething() {
      // do something that listeners should be notified of.

      // notify listeners like this:
      for (Listener l : listeners) {
         l.onNotify();
      }
   }
}