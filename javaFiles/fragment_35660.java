public class MyHashMap extends HashMap<K,V> {
   @Override
   public V put(K key, V value) {
     if (key == null) { 
       throw new NullPointerException(); 
     }
     return super.put(key, value);
   }
 }