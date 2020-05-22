class MyClass {
  final String foo = "foo";
  private Consumer<String> getFn() {
    return getFn(foo);
  }
  private static Consumer<String> getFn(String localFoo) {
    return bar -> System.out.println(bar + localFoo);
  }
}