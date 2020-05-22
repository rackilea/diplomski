static ArrayList<String> test;
static {
  foo();
}

private static void foo() {
    test = new ArrayList<>();
    test.add("a");
    test.add("b");
    test.add("c");
}