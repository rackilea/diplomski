public class MyStream<T> implements Stream<T> {

    private final Stream<T> delegate;

    public MyStream(Stream<T> delegate) {
        this.delegate = delegate;
    }

    @Override
    public Stream<T> filter(Predicate<? super T> predicate) {
        return delegate.filter(predicate);
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        delegate.forEach(action);
    }

    MyStream<T> biggerThanFour() {
        return new MyStream<>(delegate.filter(i -> ((Double) i > 4)));
    }

    // all other methods from the interface
}