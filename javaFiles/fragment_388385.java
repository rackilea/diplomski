interface ThreeConsumer<T, U, V> {
    void accept(T t, U u, V v);
}
public static <T, U, V> Consumer<T> bind2and3(
                        ThreeConsumer<? super T, U, V> c, U arg2, V arg3) {
    return (arg1) -> c.accept(arg1, arg2, arg3);
}