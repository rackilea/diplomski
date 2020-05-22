final class Foo {
  private final Bar bar;
  ...

  Foo() {
    bar = new Bar(this);

    ...
  }
}