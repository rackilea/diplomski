@FunctionalInterface
public interface Dial extends UnaryOperator<Double> {
    public default Dial andThen(UnaryOperator<Double> after) {
        return d->after.apply(apply(d));
    }
}