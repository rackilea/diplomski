public class Foo {
  private static Foo instance = new Foo();
  private static final int DELTA = 6;
  private static int BASE = 7;
  private int x;
  private Foo() {
    x = BASE + DELTA;
  }
  public static void main(String... argv) {
    System.out.println(Foo.instance.x);
  }
}