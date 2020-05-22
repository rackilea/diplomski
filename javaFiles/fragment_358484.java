@SuppressWarnings("unchecked")
@Override
public <T> ParamConverter<T> getConverter(Class<T> rawType,
        Type genericType, Annotation[] annotations) {
    if (rawType == Date.class) {
        return (ParamConverter<T>) this;
    }
    return null;
}