private Collection<Foo> mergeDuplicates(Collection<Foo> fooCollection) {
    return fooCollection.stream()
            .collect(Collectors.toMap(Foo::getId, Foo::getChildren, this::mergeChildren))
            .entrySet().stream()
            .map(e -> new Foo(e.getKey(), e.getValue()))
            .collect(Collectors.toCollection(ArrayList::new)); // collect accordingly
}