public class JsonApiDeserializer extends JsonDeserializer<Object> implements
        ContextualDeserializer {

    private Class<?> targetClass;

    public JsonApiDeserializer() {
    }

    public JsonApiDeserializer(Class<?> targetClass) {
        this.targetClass = targetClass;
    }

    @Override
    public Object deserialize(JsonParser p, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        Object clazz = targetClass.newInstance();
        //Now I have an instance of the annotated class I can populate the fields via reflection
        return clazz;
    }

    @Override
    public JsonDeserializer<?> createContextual(DeserializationContext ctxt,
            BeanProperty property) throws JsonMappingException {
        //gets the class type of the annotated class
        targetClass = ctxt.getContextualType().getRawClass();
        //this new JsonApiDeserializer will be cached
        return new JsonApiDeserializer(targetClass);
    }
}