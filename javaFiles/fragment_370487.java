public class JacksonJsonProviderProvider implements Provider<JacksonJsonProvider> {
    private final ObjectMapper mapper;

    @Inject
    JacksonJsonProviderProvider(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public JacksonJsonProvider get() {
        return new JacksonJsonProvider(mapper);
    }
}