@Provider
public class OffsetDateTimeProvider implements ParamConverterProvider {

    @Override
    public <T> ParamConverter<T> getConverter(Class<T> clazz, Type type, Annotation[] annotations) {
        if (clazz.getName().equals(OffsetDateTime.class.getName())) {

            return new ParamConverter<T>() {

                @SuppressWarnings("unchecked")
                @Override
                public T fromString(String value) {
                    OffsetDateTime time = ...
                    return (T) time;
                }

                @Override
                public String toString(T time) {
                    return ...;
                }
            };
        }
        return null;
    }
}