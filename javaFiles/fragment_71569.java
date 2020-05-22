public interface Typed {
    int getNumericType();

    static <E extends Enum<E> & Typed> E getType(E[] values, int type) {
        for (E value : values)
            if (value.getNumericType() == type)
                return value;
        throw new IllegalArgumentException(values[0].getClass().getSimpleName() +
                                           " not found: " + type);
    }
}