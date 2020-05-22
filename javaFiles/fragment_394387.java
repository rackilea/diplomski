@Provider
public class DateParamConverterProvider implements ParamConverterProvider {

    private final String format;

    public DateParamConverterProvider(String dateFormat) {
        this.format = dateFormat;
    }

    @Override
    public <T> ParamConverter<T> getConverter(Class<T> rawType, 
                                              Type genericType, 
                                              Annotation[] annotations) {

        if (rawType != Date.class) { return null; }

        return (ParamConverter<T>) new ParamConverter<Date>() {

            @Override
            public Date fromString(String value) {
                SimpleDateFormat formatter = new SimpleDateFormat(format);
                try {
                    return formatter.parse(value);
                } catch (Exception ex) {
                    throw new WebApplicationException("Bad formatted date", 400);
                }
            }

            @Override
            public String toString(Date date) { 
                return new SimpleDateFormat(format).format(date); 
            }
        };
    }
}