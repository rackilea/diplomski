final static class CancellableReduceSpliterator<T, A> implements Spliterator<A>,
        Consumer<T>, Cloneable {
    private Spliterator<T> source;
    private final BiFunction<A, ? super T, A> accumulator;
    private final Predicate<A> cancelPredicate;
    private final AtomicBoolean cancelled = new AtomicBoolean();
    private A acc;

    CancellableReduceSpliterator(Spliterator<T> source, A identity,
            BiFunction<A, ? super T, A> accumulator, Predicate<A> cancelPredicate) {
        this.source = source;
        this.acc = identity;
        this.accumulator = accumulator;
        this.cancelPredicate = cancelPredicate;
    }

    @Override
    public boolean tryAdvance(Consumer<? super A> action) {
        if (source == null || cancelled.get()) {
            source = null;
            return false;
        }
        while (!cancelled.get() && source.tryAdvance(this)) {
            if (cancelPredicate.test(acc)) {
                cancelled.set(true);
                break;
            }
        }
        source = null;
        action.accept(acc);
        return true;
    }

    @Override
    public void forEachRemaining(Consumer<? super A> action) {
        tryAdvance(action);
    }

    @Override
    public Spliterator<A> trySplit() {
        if(source == null || cancelled.get()) {
            source = null;
            return null;
        }
        Spliterator<T> prefix = source.trySplit();
        if (prefix == null)
            return null;
        try {
            @SuppressWarnings("unchecked")
            CancellableReduceSpliterator<T, A> result = 
                (CancellableReduceSpliterator<T, A>) this.clone();
            result.source = prefix;
            return result;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    @Override
    public long estimateSize() {
        // let's pretend we have the same number of elements
        // as the source, so the pipeline engine parallelize it in the same way
        return source == null ? 0 : source.estimateSize();
    }

    @Override
    public int characteristics() {
        return source == null ? SIZED : source.characteristics() & ORDERED;
    }

    @Override
    public void accept(T t) {
        this.acc = accumulator.apply(this.acc, t);
    }
}