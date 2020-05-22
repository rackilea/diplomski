public class B {
  private final A a;
  public B(A a) {
    this.a = a;
  }
  public void nothing() {
    ...
    this.a.something();
    ...
  }
}