public static double power(double x, int n) {
  if (n == 0) return 1;
  if (n == 1) return x;
  if (n == 2) return x * x;
  return power(x, n % 2) * power(power(x, n / 2), 2);
}