@Provider
public class MapperProvider implements ContextResolver<ObjectMapper> {
    final ObjectMapper mapper;

    public MapperProvider() {
        mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(
                PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
    }

    @Override
    public ObjectMapper getContext(Class<?> cls) {
        return mapper;
    }
}