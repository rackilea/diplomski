public void waysToClimb(int n, String s) {
  if (n == 0) {
    System.out.println(s);
  }
  if (n >= 1) {
    waysToClimb(n - 1, s + "1 ");
  }
  if (n >= 2) {
    waysToClimb(n - 2, s + "2 ");
  }
}