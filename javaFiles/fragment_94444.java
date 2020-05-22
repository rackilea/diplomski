public class UniquePropertyPolymorphicDeserializer<T> extends StdDeserializer<T> {

    private Map<String, Class<? extends T>> registry;

    public UniquePropertyPolymorphicDeserializer(Class<T> clazz) {
        super(clazz);
        registry = new HashMap<String, Class<? extends T>>();
    }

    public void register(String uniqueProperty, Class<? extends T> clazz) {
        registry.put(uniqueProperty, clazz);
    }

    @Override
    public T deserialize(JsonParser p, DeserializationContext ctxt) 
            throws IOException, JsonProcessingException {

        Class<? extends T> clazz = null;

        ObjectMapper mapper = (ObjectMapper) p.getCodec();  
        ObjectNode obj = (ObjectNode) mapper.readTree(p);  
        Iterator<Entry<String, JsonNode>> elementsIterator = obj.fields();

        while (elementsIterator.hasNext()) {  
            Entry<String, JsonNode> element = elementsIterator.next();  
            String name = element.getKey();  
            if (registry.containsKey(name)) {  
                clazz = registry.get(name);  
                break;  
            }
        }

        if (clazz == null) {
            throw ctxt.mappingException(
                    "No registered unique properties found "
                    + "for polymorphic deserialization");  
        }

        return mapper.treeToValue(obj, clazz);
    }
}