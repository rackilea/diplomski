public class Foo {

  private static final Object STATIC_LOCK = new Object();
  private final Object instanceLock = new Object();

  public static void bar() {
    synchronized (STATIC_LOCK) { // acquires monitor of "STATIC_LOCK" instance
      // guarded code
    }
  }

  public static synchronized void baz() { // acquires monitor of "Foo.class" instance
    // guarded code
  }

  public void qux() {
    synchronized (instanceLock) { // acquires monitor of "instanceLock" instance
      // guarded code
    }
  }

  public synchronized void quux() { // acquires monitor of "this" instance
    // guarded code
  }
}