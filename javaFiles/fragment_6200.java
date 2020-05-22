public class PrimeSum {

  private static boolean isPrime(int n) {
    if(n % 2 == 0) return false;
    for(int i = 3; i * i <= n; i += 2) {
      if(n % i == 0) return false;
    }
    return true;
  }

  private static void findSolutions(int[] a, int n) {
    if(n >= a.length) {
      System.out.println(java.util.Arrays.toString(a));
    } else {
      for(int i = n; i < a.length; i++) {
        if(n == 0 || isPrime(a[n - 1] + a[i])) {
          int t = a[n];
          a[n] = a[i];
          a[i] = t;
          findSolutions(a, n + 1);
          t = a[n];
          a[n] = a[i];
          a[i] = t;
        }
      }
    }
  }

  public static void main(String[] args) {
    int[] a = new int[4];
    for(int i = 0; i < a.length; i++) {
      a[i] = i + 1;
    }
    findSolutions(a, 0);
  }
}