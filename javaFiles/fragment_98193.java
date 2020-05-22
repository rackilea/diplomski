public class ArgTest {

  int summation(int a, int b, int c, int d, int e, int f) {
    return a + b + c + d + e + f;
  }

  int summationVArgs(int... args) {
    int sum = 0;
    for (int arg : args) {
      sum += arg;
    }
    return sum;
  }

  final static public int META_ITERATIONS = 200;
  final static public int ITERATIONS = 1000000;

  static public void main(String[] args) {
    final ArgTest at = new ArgTest();
    for (int loop = 0; loop < META_ITERATIONS; loop++) {
      int sum = 0;
      final long fixedStart = System.currentTimeMillis();
      for (int i = 0; i < ITERATIONS; i++) {
        sum += at.summation(2312, 45569, -9816, 19122, 4991, 901776);
      }
      final long fixedEnd = System.currentTimeMillis();
      final long vargStart = fixedEnd;
      for (int i = 0; i < ITERATIONS; i++) {
        sum += at.summationVArgs(2312, 45569, -9816, 19122, 4991, 901776);
      }
      final long vargEnd = System.currentTimeMillis();
      System.out.printf("%03d:%d Fixed-Args: %d ms\n", loop+1, ITERATIONS, fixedEnd - fixedStart);
      System.out.printf("%03d:%d Vargs-Args: %d ms\n", loop+1, ITERATIONS, vargEnd - vargStart);
    }
    System.exit(0);
  }

}