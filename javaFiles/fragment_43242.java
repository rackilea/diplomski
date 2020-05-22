private final TV convertForward(SV value) {
    if (converter == null) {
        Class<?> targetType = noPrimitiveType(targetProperty.getWriteType(targetObject));
        return (TV)targetType.cast(Converter.defaultConvert(value, targetType));
    }

    return converter.convertForward(value);
}