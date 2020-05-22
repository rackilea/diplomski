public static long f(int n){
  try {
    return 0 / n + n * f(n-1);
  } catch(ArithmeticException ae) {
    return 1;
  }
}