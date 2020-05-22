package foo.p2;
import foo.p1.Target;
public class Main {
  public static void main(String[] args) throws Exception {
    Target.Foo foo = Target.newFoo();
    foo.getClass()
        .getMethod("bar")
        .invoke(foo);
  }
}