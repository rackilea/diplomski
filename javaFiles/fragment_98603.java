public static <E extends Exception, V> Result<E, V> of(ThrowingSupplier<V, E> v) {
    try {
        return value(v.get());
    }
    catch(RuntimeException|Error x) {
        throw x; // unchecked throwables
    }
    catch(Exception ex) {
        @SuppressWarnings("unchecked") E e = (E)ex;
        return error(e);
    }
}