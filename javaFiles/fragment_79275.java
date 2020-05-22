public class TransferMap<K,V> implements Map<K,V>{
  @GuardedBy("lock")
  private final HashMap<K,V> backingMap = new HashMap<K,V>();

  private final Object lock = new Object();
  public V getAndWait(Object key){
     synchronized(lock){
       V value = null;
         do{
            value = backingMap.get(key);

            if(value == null) lock.wait();

         }while(value == null); 
      }
      return value;
     }
   public V put(K key, V value){
      synchronized(lock){
         V value = backingMap.put(key,value);
         lock.notifyAll();
      }
     return value;
   }
  }