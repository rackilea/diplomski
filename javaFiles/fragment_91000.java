// GetSetA.scala
trait GetSetA { def a: Int; def a_=(a: Int): Unit }

// JavaUsesGSA.java
public class JavaUsesGSA implements GetSetA {
  private int a = 0;
  public int a() { return a; }
  public void a_$eq(int a) { this.a = a; }
}