class StringToEnumConverterFactory<T extends Enum<T>>
implements ConverterFactory<String, T> {
//                                  ^
    @Override
    public <E extends T> Converter<String, E> getConverter(Class<E> targetType) {
//          ^^^^^^^^^^^                    ^                     ^
        return new StringToEnumConverter<E>(targetType);
//                                       ^
    }
// ...
}