import com.google.inject.Provider;

public class ObjectMapperProvider implements Provider<ObjectMapper> {
    @Override
    public ObjectMapper get() {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new Hibernate4Module());
        return mapper;
    }
}