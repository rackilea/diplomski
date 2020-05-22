private <T extends Number> T setNumericValue(String value, Class<T> type) {
    value = value.trim();
    if (isNumeric(value)) {
        if (type.isAssignableFrom(Float.class))
            return type.cast(Float.parseFloat(value));
        if (type.isAssignableFrom(Integer.class))
            return type.cast(Integer.parseInt(value));
    } else {
        if (type.isAssignableFrom(Float.class))
            return type.cast(Float.valueOf(0));
        if (type.isAssignableFrom(Integer.class))
            return type.cast(Integer.valueOf(0));
    }

    throw new IllegalArgumentException(String.format(
            "Cannot convert '%s' to %s", value, type.getSimpleName()
    ));
}