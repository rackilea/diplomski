public static Stream<String> concatWithPrevious(Stream<String> source) {
    boolean parallel = source.isParallel();
    Spliterator<String> sp = source.spliterator();
    return StreamSupport.stream(new Spliterators.AbstractSpliterator<String>(
        sp.estimateSize(),
        sp.characteristics()&~(Spliterator.DISTINCT|Spliterator.SORTED)) {

        private String previous;

        @Override
        public boolean tryAdvance(Consumer<? super String> action) {
            return sp.tryAdvance(s -> {
                String p = previous;
                previous = s;
                action.accept(p == null? s: s == null? p: p.concat(s));
            });
        }
    }, parallel).onClose(source::close);
}