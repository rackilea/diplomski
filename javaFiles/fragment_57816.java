public static <T,K,R> Stream<R> pairs(Stream<T> a, Stream<T> b, 
                 Function<T, K> keyExtractor, BiFunction<T, T, R> merger) {
    Map<K, Queue<T>> aMap = new HashMap<>();
    Map<K, Queue<T>> bMap = new HashMap<>();
    Spliterator<T> aSpltr = a.spliterator();
    Spliterator<T> bSpltr = b.spliterator();

    Spliterator<R> res = new Spliterators.AbstractSpliterator<R>(Math.min(
            aSpltr.estimateSize(), bSpltr.estimateSize()), Spliterator.ORDERED) {
        T at, bt;
        boolean hasBuffered = false;
        R buf;

        @Override
        public boolean tryAdvance(Consumer<? super R> action) {
            if(hasBuffered) {
                hasBuffered = false;
                action.accept(buf);
                return true;
            }
            while(true) {
                if(!aSpltr.tryAdvance(t -> at = t) || !bSpltr.tryAdvance(t -> bt = t))
                    return false;
                K ak = keyExtractor.apply(at);
                K bk = keyExtractor.apply(bt);
                Queue<T> bq = bMap.get(ak);
                boolean found = false;
                if(bq != null) {
                    found = true;
                    action.accept(merger.apply(at, bq.poll()));
                    if(bq.isEmpty()) bMap.remove(ak);
                } else {
                    aMap.computeIfAbsent(ak, k -> new ArrayDeque<>()).add(at);
                }
                Queue<T> aq = aMap.get(bk);
                if(aq != null) {
                    if(found) {
                        hasBuffered = true;
                        buf = merger.apply(aq.poll(), bt);
                    } else {
                        found = true;
                        action.accept(merger.apply(aq.poll(), bt));
                    }
                    if(aq.isEmpty()) aMap.remove(bk);
                } else {
                    bMap.computeIfAbsent(bk, k -> new ArrayDeque<>()).add(bt);
                }
                if(found)
                    return true;
            }
        }
    };
    return StreamSupport.stream(res, a.isParallel() || b.isParallel())
              .onClose(a::close).onClose(b::close);
}