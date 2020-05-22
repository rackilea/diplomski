/**
 * Associates all maps with our custom serialization mechanism, which will transform them into arrays of arrays
 * @see MapAsArraySerializer
 * @return
 */
@Produces
public SerializerFactory createSerializerFactory() {
    CustomSerializerFactory customized = new CustomSerializerFactory();
    customized.addGenericMapping(Map.class, new MapAsArraySerializer());
    return customized;
}

public @Produces ObjectMapper createMapper() {
    ObjectMapper jsonMapper = new ObjectMapper();
    // ....
    // now configure serializer
    jsonMapper.setSerializerFactory(createSerializerFactory());
    // ....
    return jsonMapper;
}