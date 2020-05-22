public class Bar {
  @RuntimeType
  public void bar (String s, Integer i) {
    System.out.println ("s:" + s + " i:" + i);
  }
}
public class Baz {
  @RuntimeType
  public void baz (Integer i, String s) {
    System.out.println ("i:" + i + " s:" + s);
  }
}