import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;


public class ThreadSafeMultition <K, V> {
  private final ConcurrentHashMap<K, FutureTask<V>> map = new ConcurrentHashMap<K, FutureTask<V>>();
  private ValueFactory<K, V> factory;

  public ThreadSafeMultition(ValueFactory<K, V> factory) {
    this.factory = factory;
  }

  public V get(K key) throws InterruptedException, ExecutionException {
    FutureTask<V> f = map.get(key);
    if (f == null) {
      f = new FutureTask<V>(new FactoryCall(key));
      FutureTask<V> existing = map.putIfAbsent(key, f);
      if (existing != null)
        f = existing;
      else // Item added successfully. Now that exclusiveness is guaranteed, start value creation.
        f.run();
    } 

    return f.get();
  }

  public static interface ValueFactory<K, V> {
    public V create(K key) throws Exception;
  }

  private class FactoryCall implements Callable<V> {
    private K key;

    public FactoryCall(K key) {
      this.key = key;
    }

    @Override
    public V call() throws Exception {
      return factory.create(key);
    }    
  }
}