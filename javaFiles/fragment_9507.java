public Stream<Item> flatMapRecursive(Item item) {
    if (item.getItems() == null) {
        return Stream.empty();
    }
    return Stream.concat(Stream.of(item), item.getItems().stream()
            .flatMap(MyClass::flatMapRecursive));
}