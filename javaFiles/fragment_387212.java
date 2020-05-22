public class CustomEnumConverterFactory implements
    ConverterFactory<String, Enum<?>>{

    @Override
    public <T extends Enum<?>> Converter<String, T> getConverter(
        final Class<T> targetType){
        return WithId.class.isAssignableFrom(targetType)
            ? new EnumWithIdConverter(targetType)
            : new StandardEnumConverter(targetType);
    }

}