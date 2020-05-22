abstract class X implements scala.ScalaObject {
  public X(int i) {
    System.out.println(i);
  }

  public abstract void hello(String s);

  //possibly other fields/methods mixed-in from ScalaObject
}