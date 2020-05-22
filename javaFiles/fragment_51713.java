class StringToEnumConverterFactory
implements ConverterFactory<String, Enum<?>> {
    @Override
    public <E extends Enum<?>> Converter<String, E> getConverter(
            Class<E> targetType) {
        return new StringToEnumConverter<E>(targetType);
    }
    static class StringToEnumConverter<E extends Enum<?>>
    implements Converter<String, E> {
        Class<E> enumType;
        StringToEnumConverter(Class<E> enumType) {
            this.enumType = enumType;
        }
        @Override
        public E convert(String source) {
            source = source.trim();
            // perhaps we would cache the constants somewhere
            for (E constant : enumType.getEnumConstants())
                if (constant.name().equals(source))
                    return constant;
            // also some people like to return null
            throw new IllegalArgumentException(source);
        }
    }
}