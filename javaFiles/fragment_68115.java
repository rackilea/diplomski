List<Predicate<Foo>> conditions = Arrays.asList(
        foo -> conditional1 && conditional2,
        foo -> conditional1,
        foo -> conditional2,
        foo -> true
);

return conditions.stream()
        .map(condition -> bar.stream().filter(condition))
        .map(Stream::findFirst)
        .filter(Optional::isPresent)
        .findFirst()
        .map(Optional::get)
        .map(Foo::getResult)
        .get();