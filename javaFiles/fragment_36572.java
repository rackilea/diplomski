Map<String, List<Foo>> fooBySomeName = fooList.stream()
    .filter(foo -> fooToSomeAttribute(foo).isPresent())
    .collect(Collectors.groupingBy(foo -> fooToSomeAttribute(foo).get()));

private static Optional<String> fooToSomeAttribute(Foo foo)
{
    return Optional.ofNullable(foo)
        .map(Foo::getGroup)
        .flatMap(new Converter()::getSomenameFromGroup)
        .map(SomeName::getSomeAttribute);
}