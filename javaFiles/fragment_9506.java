public Stream<Item> flatMapRecursive(Item item) {
    return Stream.concat(Stream.of(item), Optional.ofNullable(item.getItems())
            .orElseGet(Collections::emptyList)
            .stream()
            .flatMap(MyClass::flatMapRecursive));
}