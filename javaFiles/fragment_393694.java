public static void main(String[]a){
    ChurchNumeral five = ChurchNumeral.valueOf(5);
    System.out.println(five.apply(s -> s + s, "s"));
    System.out.println(five.apply(Math::sqrt, Double.MAX_VALUE));
}
@FunctionalInterface
private interface ChurchNumeralT<T> extends ChurchNumeral {
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    default<U> U apply(UnaryOperator<U> f, U arg){
        return (U)((ChurchNumeralT)this).tapply(f, arg);
    }
    T tapply(UnaryOperator<T> f, T arg);
}
public interface ChurchNumeral {

    <T> T apply(UnaryOperator<T> f, T arg);

    static ChurchNumeral valueOf(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Argument n must be non-negative.");
        }
        if (n == 0) {
            return (ChurchNumeralT<?>)(f, arg) -> arg;
        }
        return (ChurchNumeralT<?>)(f, arg) -> f.apply(valueOf(n - 1).apply(f, arg));
    }
}