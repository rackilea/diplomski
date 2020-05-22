abstract class A {
  public final void init() {
    // insert prologue here
    initImpl();
    // insert epilogue here
  }
  protected abstract void initImpl();
}

class B extends A {
  protected void initImpl() {
    // ...
  }
}