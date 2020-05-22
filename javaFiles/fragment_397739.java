interface Predicate<T> {
  boolean isTrueFor(T item);
}

Foo getFirst(List<Foo> listFoo, Predicate<Foo> pred) {
  for(Foo f:listFoo) {
    if(pred.isTrueFor(f)) {
      return f;
    }
  }
}

class FooPredicateBar implements Predicate<Foo> {
  private final String expected;
  FooPredicateBar(String expected) {
    this.expected = expected;
  }
  public boolean isTrueFor(Foo item) {
    return item != null && expected.equals(item.getBar());
  }
}
...
List<Foo> listFoo;
Foo theItem = getFirst(listFoo, new FooPredicateBar("Baz"));