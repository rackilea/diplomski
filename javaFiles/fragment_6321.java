static <T> Stream<T> dropWhile(Predicate<T> p, Stream<T> s) {
    Spliterator<T> sp = s.spliterator();
    return StreamSupport.stream(new Spliterators.AbstractSpliterator<T>(
            sp.estimateSize(), sp.characteristics() & ~Spliterator.SIZED) {
        boolean dropped;
        public boolean tryAdvance(Consumer<? super T> action) {
            if(dropped) return sp.tryAdvance(action);
            do {} while(!dropped && sp.tryAdvance(t -> {
                if(!p.test(t)) {
                    dropped=true;
                    action.accept(t);
                }
            }));
            return dropped;
        }
        public void forEachRemaining(Consumer<? super T> action) {
            while(!dropped) if(!tryAdvance(action)) return;
            sp.forEachRemaining(action);
        }
    }, s.isParallel());
}