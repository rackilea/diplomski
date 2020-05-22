public static <T> Stream<T> enumerationAsStream(Enumeration<T> e) {
    return StreamSupport.stream(
        new Spliterators.AbstractSpliterator<T>(Long.MAX_VALUE, Spliterator.ORDERED) {
            public boolean tryAdvance(Consumer<? super T> action) {
                if(e.hasMoreElements()) {
                    action.accept(e.nextElement());
                    return true;
                }
                return false;
            }
            public void forEachRemaining(Consumer<? super T> action) {
                while(e.hasMoreElements()) action.accept(e.nextElement());
            }
    }, false);
}