public interface Dial extends UnaryOperator<Double> {
    @Override
    public default <R>
    Function<Double, R> andThen(Function<? super Double, ? extends R> after) {
        return UnaryOperator.super.andThen(after);
    }
}