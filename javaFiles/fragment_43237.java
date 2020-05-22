public class AnimalDeserializer extends StdDeserializer<IAnimal> {

    private Map<String, Class<? extends IAnimal>> registry =  new HashMap<String, Class<? extends Animal>>();  

    public AnimalDeserializer()  {  
        super(IAnimal.class);  
    }  

    public void registerAnimal(String uniqueAttribute, Class<? extends IAnimal> animalClass) {  
        registry.put(uniqueAttribute, animalClass);  
    }  

    @Override  
    public IAnimal deserialize(JsonParser parser, DeserializationContext context) throws IOException, JsonProcessingException {  
        ObjectMapper mapper = (ObjectMapper) parser.getCodec();  
        ObjectNode root = (ObjectNode) mapper.readTree(parser);  

        Class<? extends IAnimal> animalClass = null;  
        Iterator<Entry<String, JsonNode>> iterator = root.getFields();  
        boolean found = false;
        while (!found &&iterator.hasNext()) {  
            Entry<String, JsonNode> element = elementsIterator.next();  
            String name = element.getKey();  

            if(registry.containsKey(name)) {  
                animalClass = registry.get(name);  
                found = true;
            }
        }  

        if(animalClass == null) {
            return null;  
        } else {
            return mapper.readValue(root, animalClass);  
        }
    }  
}