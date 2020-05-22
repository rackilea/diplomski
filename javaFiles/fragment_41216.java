public interface IEachCallback<T, E> extends IAsyncCallback<T, E> {

    @Override
    default void done(E e, T t) {
        this.done(t);
    }

    void done(T e);
}