public static int count11(long n) {
  int cnt = 0;
  while (n != 0) {
    if ((n & 3) == 3) cnt++;
    n >>>= 2;
  }
  return cnt;
}