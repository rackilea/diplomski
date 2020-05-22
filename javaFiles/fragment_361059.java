int n = 128;
while (n > 0) {
  int d = n / 10;
  int k = n - d * 10;
  n = d;
  System.out.println(k);
}