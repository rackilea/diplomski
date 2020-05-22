public interface IAsyncCallback<T, E> {
    void done(E e, T v);

    static <E> IAsyncCallback<Void, E> ofConsumer(Consumer<E> callback) {
        return (t, e) -> callback.accept(t);
    }
}