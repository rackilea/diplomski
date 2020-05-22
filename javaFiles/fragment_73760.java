@Configuration
public class MongoConfiguration {

    @Bean
    public MongoCustomConversions customConversions() {
        List<Converter<?, ?>> converters = new ArrayList<>();
        converters.add(new DateToLocalDateTimeConverter());
        converters.add(new LocalDateTimeToDateConverter());
        return new MongoCustomConversions(converters);
    }

    class DateToLocalDateTimeConverter implements Converter<Date, LocalDateTime> {

        @Override
        public LocalDateTime convert(Date source) {
            return source == null ? null : 
                LocalDateTime.ofInstant(source.toInstant(), ZoneId.systemDefault());
        }
    }

    class LocalDateTimeToDateConverter implements Converter<LocalDateTime, Date> {

        @Override
        public Date convert(LocalDateTime source) {
            return source == null ? null : Date.from(source.toInstant());
        }
    }
}