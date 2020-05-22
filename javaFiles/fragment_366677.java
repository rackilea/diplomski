public class AFactory {
    private final Map<Key, A> aMap = new HashMap<>(a);

    public A buildA(Key key) {
         synchronized (aMap) {
             A a = aMap.get(key);
             if (a == null) {
                  a = new A();
                  aMap.put(key, a);
             }
         }
         return a;
    }

    public A getA(Key key) {
       synchronized(aMap) {
          return aMap.get(key);
       }
    }
}