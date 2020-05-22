@Configuration
public class MongoDbCommonConfiguration {

    @Bean
    public ValidatingMongoEventListener validatingMongoEventListener() {
        return new ValidatingMongoEventListener(validator());
    }

    @Bean
    public LocalValidatorFactoryBean validator() {
        return new LocalValidatorFactoryBean();
    }

    @Bean
    @Primary
    public CustomConversions customConversions() {
        ZonedDateTimeReadConverter zonedDateTimeReadConverter = new ZonedDateTimeReadConverter();
        ZonedDateTimeWriteConverter zonedDateTimeWriteConverter = new ZonedDateTimeWriteConverter();

        return new CustomConversions(Arrays.asList(zonedDateTimeReadConverter, zonedDateTimeWriteConverter));
    }
}