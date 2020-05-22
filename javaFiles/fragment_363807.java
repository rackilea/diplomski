public class Test {
  public Test(int iterations) {
    int n = iterations;
    double sum = 0;
    while (n > 0) {
      sum = Math.sqrt(sum + n--);
    }
    System.out.printf("Precision using %d iterations: %1.50f\n", iterations, sum);
  }

  public static void main(String[] args) {
    new Test(1);
    new Test(10);
    new Test(100);
    new Test(1000);
    new Test(10000);
    new Test(100000);
    new Test(1000000);
    new Test(10000000);
    new Test(100000000);
  }
}