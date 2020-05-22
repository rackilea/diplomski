public class CustomObjectMapper extends ObjectMapper {

    public CustomObjectMapper() {
        CustomSerializerFactory sf = new CustomSerializerFactory();
        sf.addSpecificMapping(ObjectId.class, new ObjectIdSerializer());
        this.setSerializerFactory(sf);
    }
}