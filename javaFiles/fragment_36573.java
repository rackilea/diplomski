Map<String, List<Foo>> fooBySomeName = fooList.stream()
    .filter(Objects::nonNull)
    .map(FooAndSomeAttribute::new)
    .filter(pair -> pair.getSomeAttribute().isPresent())
    .collect(Collectors.groupingBy(
        pair -> pair.getSomeAttribute().get(),
        Collectors.mapping(
            FooAndSomeAttribute::getFoo, 
            Collectors.toList())));

private static class FooAndSomeAttribute
{
    private final Foo foo;
    private final Optional<String> someAttribute;

    public FooAndSomeAttribute(Foo foo)
    {
        this.foo = foo;
        this.someAttribute = Optional.ofNullable(foo)
            .map(Foo::getGroup)
            .flatMap(new Converter()::getSomenameFromGroup)
            .map(SomeName::getSomeAttribute);
    }

    public Foo getFoo() 
    {
        return foo;
    }

    public Optional<String> getSomeAttribute() 
    {
        return someAttribute;
    }
}