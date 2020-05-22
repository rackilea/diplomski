package foo.p1;
public class Target {
  public static interface Foo {
    public void bar();
  }

  public static Foo newFoo() {
    return new Foo() {
      @Override
      public void bar() { 
      }
    };
  }
}