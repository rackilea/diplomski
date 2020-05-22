public class A {
  public static void do() {
    doImpl(A.class);
  }
  protected static void doImpl(Class<?> refClass) {
  }
}

public class B extends A {
  public static void do() {
    doImpl(B.class);
  }
}