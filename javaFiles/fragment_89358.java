final int target = 42;
Ordering<Foo> ordering = Ordering.natural().onResultOf(
    new Function<Foo, Integer>() {
      @Override public Integer apply(Foo foo) {
        return Math.abs(foo.field - target);
      }
    });