public class PeelingStream<T> implements Stream<T> {

    private Stream<T> wrapped;

    public PeelingStream(Stream<T> toBeWrapped) {
        this.wrapped = toBeWrapped;
    }

    public T getNext() {
        Iterator<T> iterator = wrapped.iterator();
        T next = iterator.next();
        Iterable<T> remainingIterable = () -> iterator;
        wrapped = StreamSupport.stream(remainingIterable.spliterator(),
                false);

        return next;
    }

    ///////////////////// from here, only plain delegate methods

    public Iterator<T> iterator() {
        return wrapped.iterator();
    }

    public Spliterator<T> spliterator() {
        return wrapped.spliterator();
    }

    public boolean isParallel() {
        return wrapped.isParallel();
    }

    public Stream<T> sequential() {
        return wrapped.sequential();
    }

    public Stream<T> parallel() {
        return wrapped.parallel();
    }

    public Stream<T> unordered() {
        return wrapped.unordered();
    }

    public Stream<T> onClose(Runnable closeHandler) {
        return wrapped.onClose(closeHandler);

    }

    public void close() {
        wrapped.close();
    }

    public Stream<T> filter(Predicate<? super T> predicate) {
        return wrapped.filter(predicate);
    }

    public <R> Stream<R> map(Function<? super T, ? extends R> mapper) {
        return wrapped.map(mapper);
    }

    public IntStream mapToInt(ToIntFunction<? super T> mapper) {
        return wrapped.mapToInt(mapper);
    }

    public LongStream mapToLong(ToLongFunction<? super T> mapper) {
        return wrapped.mapToLong(mapper);
    }

    public DoubleStream mapToDouble(ToDoubleFunction<? super T> mapper) {
        return wrapped.mapToDouble(mapper);
    }

    public <R> Stream<R> flatMap(
            Function<? super T, ? extends Stream<? extends R>> mapper) {
        return wrapped.flatMap(mapper);
    }

    public IntStream flatMapToInt(
            Function<? super T, ? extends IntStream> mapper) {
        return wrapped.flatMapToInt(mapper);
    }

    public LongStream flatMapToLong(
            Function<? super T, ? extends LongStream> mapper) {
        return wrapped.flatMapToLong(mapper);
    }

    public DoubleStream flatMapToDouble(
            Function<? super T, ? extends DoubleStream> mapper) {
        return wrapped.flatMapToDouble(mapper);
    }

    public Stream<T> distinct() {
        return wrapped.distinct();
    }

    public Stream<T> sorted() {
        return wrapped.sorted();
    }

    public Stream<T> sorted(Comparator<? super T> comparator) {
        return wrapped.sorted(comparator);
    }

    public Stream<T> peek(Consumer<? super T> action) {
        return wrapped.peek(action);
    }

    public Stream<T> limit(long maxSize) {
        return wrapped.limit(maxSize);
    }

    public Stream<T> skip(long n) {
        return wrapped.skip(n);
    }

    public void forEach(Consumer<? super T> action) {
        wrapped.forEach(action);
    }

    public void forEachOrdered(Consumer<? super T> action) {
        wrapped.forEachOrdered(action);
    }

    public Object[] toArray() {
        return wrapped.toArray();
    }

    public <A> A[] toArray(IntFunction<A[]> generator) {
        return wrapped.toArray(generator);
    }

    public T reduce(T identity, BinaryOperator<T> accumulator) {
        return wrapped.reduce(identity, accumulator);
    }

    public Optional<T> reduce(BinaryOperator<T> accumulator) {
        return wrapped.reduce(accumulator);
    }

    public <U> U reduce(U identity,
            BiFunction<U, ? super T, U> accumulator,
            BinaryOperator<U> combiner) {
        return wrapped.reduce(identity, accumulator, combiner);
    }

    public <R> R collect(Supplier<R> supplier,
            BiConsumer<R, ? super T> accumulator, BiConsumer<R, R> combiner) {
        return wrapped.collect(supplier, accumulator, combiner);
    }

    public <R, A> R collect(Collector<? super T, A, R> collector) {
        return wrapped.collect(collector);
    }

    public Optional<T> min(Comparator<? super T> comparator) {
        return wrapped.min(comparator);
    }

    public Optional<T> max(Comparator<? super T> comparator) {
        return wrapped.max(comparator);
    }

    public long count() {
        return wrapped.count();
    }

    public boolean anyMatch(Predicate<? super T> predicate) {
        return wrapped.anyMatch(predicate);
    }

    public boolean allMatch(Predicate<? super T> predicate) {
        return wrapped.allMatch(predicate);
    }

    public boolean noneMatch(Predicate<? super T> predicate) {
        return wrapped.noneMatch(predicate);
    }

    public Optional<T> findFirst() {
        return wrapped.findFirst();
    }

    public Optional<T> findAny() {
        return wrapped.findAny();
    }

}