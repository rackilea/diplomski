@SuppressWarnings("unchecked")
public static <N extends Number> N multiply(N number, int multiplier) {
    Class<? extends Number> cls = number.getClass();
    if (cls == Integer.class) {
        return (N) Integer.valueOf(number.intValue() * multiplier);
    }
    if (cls == Long.class) {
        return (N) Long.valueOf(number.longValue() * multiplier);
    }
    throw new UnsupportedOperationException("unknown class: " + cls);
}