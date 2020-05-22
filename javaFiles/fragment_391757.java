public static <T> Stream<T> enumerationAsStream(Enumeration<T> e) {
    return StreamSupport.stream(
        Spliterators.spliteratorUnknownSize(
            new Iterator<T>() {
                public T next() {
                    return e.nextElement();
                }
                public boolean hasNext() {
                    return e.hasMoreElements();
                }
                public void forEachRemaining(Consumer<? super T> action) {
                    while(e.hasMoreElements()) action.accept(e.nextElement());
                }
            },
            Spliterator.ORDERED), false);
}