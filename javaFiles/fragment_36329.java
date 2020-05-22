class SimpleMonoidOps<T> implements MonoidOps<T> {
    private final T idElem;
    private final BinaryOperator<T> operation;

    public SimpleMonoidOps(T idElem, BinaryOperator<T> operation) {
        this.idElem = idElem;
        this.operation = operation;
    }

    public T id() {
        return idElem;
    }

    public T op(T o1, T o2) {
        return operation.apply(o1, o2);
    }
}