static <T> Stream<T> defaultIfEmpty(Stream<T> stream, Supplier<T> supplier) {
    Iterator<T> iterator = stream.iterator();
    if (iterator.hasNext()) {
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(iterator, 0), false);
    } else {
        return Stream.of(supplier.get());
    }
}