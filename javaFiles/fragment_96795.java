interface MyOperator extends UnaryOperator<String> {
    static MyOperator identity() {
        return s -> s;
    }

    default MyOperator andThen(MyOperator after) {
        Objects.requireNonNull(after);
        return s -> after.apply(this.apply(s));
    }

    default MyOperator compose(MyOperator before) {
        Objects.requireNonNull(before);
        return s -> this.apply(before.apply(s));
    }
}