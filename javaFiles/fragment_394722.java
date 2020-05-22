try {
    throw new Foo<String>("test");
} catch(Foo<Int> e) {
  // int
} catch(Foo<String> e) {
  // string
}