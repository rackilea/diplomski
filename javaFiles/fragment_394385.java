public class ObjectMapperFactory implements Factory<ObjectMapper> {

    private final Providers providers;
    final ObjectMapper mapper = new ObjectMapper();

    public ObjectMapperFactory(@Context Providers providers) {
        this.providers = providers;
    }

    @Override
    public ObjectMapper provide() {
        ContextResolver<ObjectMapper> resolver = providers.getContextResolver(
                ObjectMapper.class, MediaType.APPLICATION_JSON);
        if (resolver == null) { return mapper; }

        return resolver.getContext(null);
    }

    @Override
    public void dispose(ObjectMapper t) {}   
}