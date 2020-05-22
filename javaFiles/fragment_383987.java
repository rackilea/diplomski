public class Test {
  public static void main(String[] args) {
    double x = 1;
    System.out.println(x - Math.ulp(x) == Math.nextAfter(x, Double.NEGATIVE_INFINITY));
    System.out.println(x + Math.ulp(x) == Math.nextAfter(x, Double.POSITIVE_INFINITY));
  }
}