@FunctionalInterface
interface UnaryOperator<T> extends Function<T, T> {
    static UnaryOperator<Object> IDENTITY_FUNCTION = (k -> k);
    static <T> UnaryOperator<T> identity() {
        return (UnaryOperator)IDENTITY_FUNCTION;
    }
}