class MyClass {
  final String foo = "foo";
  private Consumer<String> getFn() {
    String localFoo = foo;
    return bar -> System.out.println(bar + localFoo);
  }
}