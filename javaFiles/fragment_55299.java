ServiceLoader<StringConverterProvider> converterProviderLoader
    = ServiceLoader.load(StringConverterProvider.class);

T convert(String s, Class<T> t){
    for(StringConverterProvider scProv : converterProviderLoader){
        StringConverter<T> converter = scProv.getConverterFor(t);
        if (converter != null)
            return converter.convert(s);
        }
    return null;
}