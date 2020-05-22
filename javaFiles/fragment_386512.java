public XdmStream<T> untilFirst(Predicate<? super XdmItem> predicate) {
    Stream<T> stoppable = base.peek(item -> {
        if (predicate.test(item)) {
            base.close();
        }
    });
    return new XdmStream<T>(stoppable);
}