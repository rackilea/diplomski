@Provider
public class LocalDateParamConverterProvider implements ParamConverterProvider {

    final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    public <T> ParamConverter<T> getConverter(
            Class<T> rawType, Type genericType, Annotation[] antns) {

        if (LocalDate.class == rawType) {
            return new ParamConverter<T>() {
                @Override
                public T fromString(String string) {
                    try {
                        LocalDate localDate = LocalDate.parse(string, formatter);
                        return rawType.cast(localDate);
                    } catch (Exception ex) {
                        throw new BadRequestException(ex);
                    }
                }

                @Override
                public String toString(T t) {
                    LocalDate localDate = (LocalDate) t;
                    return formatter.format(localDate);
                }
            };
        }

        return null;
    }
}