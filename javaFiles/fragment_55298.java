interface StringConverterProvider{
    StringConverter<T> getConverterFor(Class<T> clazz);
}

interface StringConverter<T>{
    T convert(String s);
}