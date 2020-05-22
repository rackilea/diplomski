public static int recursiveProduct(int a, int b) {
  if (b == 0) {
    return 0;
  } else {
    return a + recursiveProduct(a,--b);
  }
}