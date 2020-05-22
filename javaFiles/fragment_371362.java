static int runs;
static void test(int n) {
  runs++;
  if (n == 0) return;
  for (int i = 0; i < 4; i++) test(n-1);
}
public static void main(String[] args) {
  for (int n = 1; n <= 5; n++) {
    runs = 0;
    test(n);
    System.out.format("%d: %d %d\n", n, 1<<(2*n), runs);
  }
}