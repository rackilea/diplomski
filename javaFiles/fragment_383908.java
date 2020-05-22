public void print(int i) {
  if (i > 0) {
    System.out.println(fib(i - 1));
    print(i - 1);
  }
}