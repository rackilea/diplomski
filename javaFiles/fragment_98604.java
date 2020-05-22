public static <E extends Exception, V> Result<E, V> of(ThrowingSupplier<V, E> v) throws E {
    try {
        return value(v.get());
    }
    catch(RuntimeException|Error x) {
        throw x; // unchecked throwables
    }
    catch(Exception ex) {
        throw ex; // can only be E
    }
}