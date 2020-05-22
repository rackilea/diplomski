import java.lang.reflect.Method;
import java.lang.invoke.*;

public class Bar extends Foo {
  public void doit() {
    System.out.println("bad");
  }

  public static void main(String[] args) throws Throwable {
    Bar b = new Bar();
    Method m = Foo.class.getDeclaredMethod("doit", new Class[]{});
    MethodHandle h = MethodHandles.lookup().unreflectSpecial(m, Bar.class);
    h.invoke(b);
  }
}