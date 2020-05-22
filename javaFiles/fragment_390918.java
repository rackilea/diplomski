import java.util.function.IntBinaryOperator;

public class A {

  public static IntBinaryOperator addThemUp;

  public static int addThemUp(int i1, int i2) {
    return i1 + i2;
  }

  public static void main(String[] args) throws Exception {
    IntBinaryOperator operator = A::addThemUp;
  }
}