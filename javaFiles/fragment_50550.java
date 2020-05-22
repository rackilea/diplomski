class MyClass {
  static Splitter splitter = Splitter.on(CharMatcher.WHITESPACE).limit(4);

  ...

  Iterable<String> slices = splitter.split(input);
}