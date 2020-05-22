public class JsonMapperFactory {

    public static ObjectMapper configureObjectMapper(final ObjectMapper mapper, final SimpleModule module) {
        final SimpleModuleBuilder modulebuilder = new SimpleModuleBuilder();

        final SimpleModule configuredModule = modulebuilder.configure(module)
            .withSerializer(DateTime.class, new DateTimeSerializer())
            .withDeserializer(DateTime.class, new DateTimeDeserializer())
            .build();

        final ObjectMapperBuilder objectMapperBuilder = new ObjectMapperBuilder();
        return objectMapperBuilder.configure(mapper).withModule(configuredModule).build();
    }
}