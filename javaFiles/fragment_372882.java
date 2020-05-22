public class Foo {
  private static Foo instance;
  private static final int DELTA = 6;
  private static int BASE;
  static {
    instance = null;
    BASE = 0;
    instance = new Foo(); /* BASE is 0 when instance.x is computed. */
    BASE = 7;
  }
  private int x;
  private Foo() {
    x = BASE + 6; /* "6" is inlined, because it's a constant. */
  }
}