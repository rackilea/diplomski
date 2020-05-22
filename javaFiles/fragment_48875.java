@Provider
public class MoneyConverterProvider  implements ParamConverterProvider {

    private final MoneyConverter converter = new MoneyConverter();

    @Override
    public <T> ParamConverter<T> getConverter(Class<T> rawType, Type genericType, Annotation[] annotations) {
        if (!rawType.equals(Money.class)) return null;
        return (ParamConverter<T>) converter; 
    }

    public class MoneyConverter implements ParamConverter<Money> {

        public Money fromString(String value) {
            if (value == null ||value.isEmpty()) return null; // change this for production
            return Money.of(CurrencyUnit.EUR, Double.parseDouble(value));
        }

        public String toString(Money value) {
            if (value == null) return "";
            return value.getAmount().toString(); // change this for production
        }

    }
}