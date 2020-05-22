public static boolean isPrime(int n) {
  if (n == 2) return true;
  if (n < 2 || n % 2 == 0) return false;

  double sqrtN = Math.sqrt(n);
  for (int i = 3; i <= sqrtN; i += 2) {
    if (n % i == 0) return false;
  }
  return true;
}