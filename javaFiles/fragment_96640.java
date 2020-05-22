@Provider
public class GeneratedEnumParamConverterProvider implements ParamConverterProvider {

    @Override
    public <T> ParamConverter<T> getConverter(final Class<T> rawType, final Type genericType,
                                              final Annotation[] annotations) {
        try {
            final Method fromValueMethod = rawType.getMethod("fromValue", String.class);

            return new ParamConverter<T>() {
                @Override
                public T fromString(final String value) {
                    try {
                        return rawType.cast(fromValueMethod.invoke(null, value));
                    } catch (Exception e) {
                        throw new IllegalArgumentException("Given value (" + value + ") cannot be converted to parameter of type" + rawType);
                    }
                }

                @Override
                public String toString(final T value) {
                    return value.toString();
                }
            };
        } catch (Exception e) {
            return null;
        }
    }
}