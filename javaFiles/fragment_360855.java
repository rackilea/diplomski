private final static ConcurrentMap<String, MyObject> myMap =
       new ConcurrentHashMap<String, MyObject>();

public MyObject myGetter(String key) {
   MyObject ref = myMap.get(key);
   if(ref == null) {
      ref = new MyObject(key);
      MyOject put = myMap.putIfAbsent(key, ref);
      if(put != null) {
         // some other thread won put first
         ref = put;
      }
   }
   return ref;
}