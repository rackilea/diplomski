public class LazyReference<T> {     
  private T instance;
  private volatile boolean initialized;
  ...
  public T get() {
    if (!initialized) {
      synchronized (LOCK) {
        if (!initialized) {
          instance = instanceProvider.get();
          initialized = true;
        }
      }
    }
    return instance;
  }
}