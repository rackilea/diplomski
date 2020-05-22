public class SingletonClass implements Runnable {

    private boolean someValue;

    public static final SingletonClass INSTANCE = new Test();

    private Test() {
      Thread t = new Thread(this);
      t.setDaemon(true);
      t.start();
    }

    public synchronized boolean getValue() {
      return someValue;
    }

    public synchronized void setValue(boolean value) {
      someValue = value;
    }

    @Override
    public void run() {
      while (true) {
        // ... do your work here...

        // Monitor something and set values
        setValue(true);

        Thread.sleep(500);
    }
  }
}