void loop(final int n) {
  if (n == 0) {
    return;
  } else {
    System.out.println("Count: " + n);
    loop(n-1);
  }
}