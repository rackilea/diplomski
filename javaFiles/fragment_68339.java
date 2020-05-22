public class Test {
  public static Range r = null;
  public static void Main(final String[] args) {
    final Thread t1 = new Thread(new Runnable() {
      @Override void run() { r = deserialize(serialize(new Range(1, 3)); }
    });

    final Thread t2 = new Thread(new Runnable() {
      @Override void run() { System.out.println(r); }
    });

    t1.start();
    t2.start();
}