public int commonDigits(int x, int y) {
  int dX = 0;
  while (x != 0) {
    dX |= 1 << (x % 10);
    x /= 10;
  }
  int count = 0;
  while (y != 0) {
    int mask = 1 << (y % 10);
    if ((dX & mask) != 0) {
      count ++;
      dX &= ~mask;
    }
    y /= 10;
  }
  return count;
}