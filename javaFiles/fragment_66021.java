public class A {
  public void something() { ... }
  public class B {
      public void nothing() {
        ...
        something();
        ...
      }
  }