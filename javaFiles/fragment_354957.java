static String asStrangeNumber ( int i ) {
  // Lowest 4 digits are decimal.
  int low4 = i%10000;
  i /= 10000;
  // Next is base 36 - 0-9-A-Z
  int c = i % 36;
  i /= 36;
  // Remaining should be < 10.
  return String.format("%1d%c%04d", i%10, c < 10 ? '0' + c: 'A' + c - 10, low4);
}

public void test() {
  test (0);
  test (1);
  test (10);
  test (100);
  test (1000);
  test (10000);
  test (100000);
  test (1000000);

}

private void test(int i) {
  System.out.println("    "+i+" -> "+asStrangeNumber(i));
}