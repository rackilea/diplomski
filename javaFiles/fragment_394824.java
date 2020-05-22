@Provider
@Produces("application/json")
@Consumes("application/json")
public class MapperContextResolver implements ContextResolver<ObjectMapper> {

    private final ObjectMapper mapper;

    public MapperContextResolver() {
        mapper = new ObjectMapper();
        // do any configurations to mapper
    }

    @Override
    public ObjectMapper getContext(Class<?> cls) {
        return mapper;
    }
}