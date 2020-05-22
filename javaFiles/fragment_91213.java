public class Foo<R, P> {
  /*
   * Not sure how you intend to provide any kind of implementation
   * here since you don't know what R or P are.
   */
  public R bar(P parameters) { ... }
}

public class SomeFoo extends Foo<SomeResult, Pair<Baz, Bar>> {
  public SomeResult bar(Pair<Baz, Bar> parameters) { ... }
}

SomeFoo foo = ...
SomeResult result = foo.bar(Pair.of(baz, bar));