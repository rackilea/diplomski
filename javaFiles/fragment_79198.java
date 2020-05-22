public class JacksonStreamingTest extends JerseyTest {

    @Override
    protected Application configure() {
        return new ResourceConfig(PersonResource.class, ObjectMapperProvider.class);
    }

    /**
     * Registers the application {@link ObjectMapper} as the JAX-RS provider for application/json
     */
    @Provider
    @Produces(MediaType.APPLICATION_JSON)
    public static class ObjectMapperProvider implements ContextResolver<ObjectMapper> {

        private static final ObjectMapper mapper = new ObjectMapper();

        public ObjectMapper getContext(final Class<?> objectType) {
            return mapper;
        }
    }

    @Override
    protected void configureClient(final ClientConfig config) {
        config.register(ObjectMapperProvider.class);
    }

    @Test
    public void test() {
        final Set<Person> persons = Collections.singleton(Person.of("Tracy", "Jordan"));
        final Response response = target("persons/inputstream").request().post(Entity.json(persons.iterator()));
        assertThat(response.getStatus()).isEqualTo(204);
    }
}