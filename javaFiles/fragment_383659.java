class Foo {

  private String foo;

  class Bar {

    private Bar() { }

    String bar() {
      return foo;
    }
  }

  Bar bar() {
    return new Bar();
  }
}