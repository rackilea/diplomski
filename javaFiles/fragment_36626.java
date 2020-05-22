static final class UnorderedTakeWhileSpliterator<T> implements Spliterator<T>, Consumer<T>, Cloneable {
    private final Predicate<? super T> predicate;
    private final AtomicBoolean checked = new AtomicBoolean();
    private Spliterator<T> source;
    private T cur;

    UnorderedTakeWhileSpliterator(Spliterator<T> source, Predicate<? super T> predicate) {
        this.predicate = predicate;
        this.source = source;
    }

    @Override
    public void accept(T t) {
        this.cur = t;
    }

    @Override
    public boolean tryAdvance(Consumer<? super T> action) {
        if (!checked.get() && source.tryAdvance(this)) {
            if (predicate.test(cur)) {
                action.accept(cur);
                return true;
            } else {
                checked.set(true);
            }
        }
        return false;
    }

    @Override
    public Spliterator<T> trySplit() {
        Spliterator<T> prefix = source.trySplit();
        if(prefix == null) {
            return null;
        }
        if(checked.get()) {
            return Spliterators.emptySpliterator();
        }
        UnorderedTakeWhileSpliterator<T> clone;
        try {
            clone = (UnorderedTakeWhileSpliterator<T>) clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e);
        }
        clone.source = prefix;
        return clone;
    }

    @Override
    public long estimateSize() {
        return source.estimateSize();
    }

    @Override
    public int characteristics() {
        return source.characteristics() & (DISTINCT | SORTED | NONNULL);
    }

    @Override
    public Comparator<? super T> getComparator() {
        return source.getComparator();
    }
}