private static <T extends Enum<T>> T findEnumValue(final Class<T> cls,
        final Object value) {
    if (value == null) {
        return null;
    }
    if (value.getClass() == cls) {
        return cls.cast(value);
    }
    if (value instanceof String) {
        return Enum.valueOf(cls, (String)value);
    }
    return null;
}