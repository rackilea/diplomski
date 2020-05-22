public abstract static class PrimitiveNumberRef<T extends Number> extends
        Ref<T> {
    private Class<T> type;

    public PrimitiveNumberRef() {
        // This requires default constructor for Ref class
        type = getGenericType(getClass());
        super.set((T) getInitialValue(type));
    }

    @Override
    public void set(T value) {
        if (value == null) {
            throw new IllegalArgumentException(
                    "Null value is not allowed for PrimitiveNumerRef type: "
                            + type);
        }
        if (!type.isInstance(value)) {
            throw new IllegalArgumentException("Unsupported value type: "
                    + value.getClass());
        }
        super.set(value);
    }

    @SuppressWarnings("unchecked")
    private static <T> Class<T> getGenericType(Class<?> clz) {
        return (Class<T>) ((ParameterizedType) clz.getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    private static <T> T getInitialValue(Class<T> clz) {
        if (clz == Byte.class) {
            return clz.cast((byte) 0);
        } else if (clz == Short.class) {
            return clz.cast((short) 0);
        } else if (clz == Integer.class) {
            return clz.cast((int) 0);
        } else if (clz == Double.class) {
            return clz.cast((double) 0);
        } else if (clz == Float.class) {
            return clz.cast((float) 0);
        } else if (clz == Long.class) {
            return clz.cast((long) 0);
        } else {
            throw new IllegalArgumentException("Unsupported type: "
                    + clz.getName());
        }
    }
}