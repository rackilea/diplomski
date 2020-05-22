Function<Arguments, SomeObject> find = Stream.<Function<Arguments,SomeObject>>of(
    this::queryFirstSource, this::querySecondSource, this::queryThirdSource
).reduce(a->null,(f,g)->a->Optional.ofNullable(f.apply(a)).orElseGet(()->g.apply(a)));

public SomeObject findSomeObject(Arguments args) {
    return find.apply(args);
}