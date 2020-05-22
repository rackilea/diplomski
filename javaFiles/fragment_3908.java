public class MapAsArrayDeserializerFactory extends CustomDeserializerFactory {
    @Override
    public JsonDeserializer<?> createMapDeserializer(DeserializationConfig config, MapType type, DeserializerProvider p) throws JsonMappingException {
        return createBeanDeserializer(config, type, p);
    }
}