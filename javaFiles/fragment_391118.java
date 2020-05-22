public class ObjectMapperExtended extends ObjectMapper {
    private ObjectMapperExtended () {}

    public static ObjectMapperExtended create() {
        ObjectMapperExtended obj = new ObjectMapperExtended();
        obj.registerModule(new Hibernate4Module());
        return obj;
    }
}