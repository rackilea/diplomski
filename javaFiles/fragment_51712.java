class StringToEnumConverterFactory
implements ConverterFactory<String, Enum<?>> {
    @Override
    public <E extends Enum<?>> Converter<String, E> getConverter(
            Class<E> targetType) {
        return new StringToEnumConverter<E>(targetType);
    }
// ...
}