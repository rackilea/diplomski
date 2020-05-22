@Component
@Primary
public class CustomObjectMapper extends ObjectMapper {
    public CustomObjectMapper() {
        configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, true);
    }
}