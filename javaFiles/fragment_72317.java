private static int gcd(int x, int y) {
  while (y != 0) {
    int tempX = x;
    x = y;
    y = tempX % y;
  }
  return x;
}