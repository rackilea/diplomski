public static void main(String[] args) {
  String[] tests = new String[] { "0123", "9876" };
  for (String test : tests) {
    int a = Integer.parseInt(test.substring(0, 1));
    int b = Integer.parseInt(test.substring(1, 2));
    int c = Integer.parseInt(test.substring(2));
    System.out.printf("%s = a=%d, b=%d, c=%d\n", test, a,
        b, c);
  }
}