public interface IEachCallback<E> extends IAsyncCallback<Void, E> {

    @Override
    default void done(E e, Void t) {
        this.done(e);
    }

    void done(E e);

    static <E> IAsyncCallback<Void, E> ofVoid(IEachCallback<E> callback) {
        return (e, v) -> callback.done(e);
    }
}