public class JacksonCustomList {
    public static final String JSON = "{\n" +
            "  \"item\": [\n" +
            "    { \"foo\": 1 },\n" +
            "    { \"foo\": 2 }\n" +
            "  ]\n" +
            "} ";

    @Retention(RetentionPolicy.RUNTIME)
    public static @interface PreferBeanDeserializer {

    }

    public static class Item {
        public int foo;

        @Override
        public String toString() {
            return String.valueOf(foo);
        }
    }

    @PreferBeanDeserializer
    public static class ItemList extends ArrayList<Item> {
        @JsonProperty("item")
        public List<Item> items;

        @Override
        public String toString() {
            return items.toString();
        }
    }

    public static class Modifier extends BeanDeserializerModifier {
        private final MyObjectMapper mapper;

        public Modifier(final MyObjectMapper mapper) {
            this.mapper = mapper;
        }

        @Override
        public JsonDeserializer<?> modifyCollectionDeserializer(
                final DeserializationConfig config,
                final CollectionType type,
                final BeanDescription beanDesc,
                final JsonDeserializer<?> deserializer) {
            if (type.getRawClass().getAnnotation(PreferBeanDeserializer.class) != null) {
                DeserializationContext context = mapper.createContext(config);
                try {
                    return context.getFactory().createBeanDeserializer(context, type, beanDesc);
                } catch (JsonMappingException e) {
                   throw new IllegalStateException(e);
                }

            }
            return super.modifyCollectionDeserializer(config, type, beanDesc, deserializer);
        }
    }

    public static class MyObjectMapper extends ObjectMapper {
        public DeserializationContext createContext(final DeserializationConfig cfg) {
            return super.createDeserializationContext(getDeserializationContext().getParser(), cfg);
        }
    }

    public static void main(String[] args) throws IOException {
        final MyObjectMapper mapper = new MyObjectMapper();
        SimpleModule module = new SimpleModule();
        module.setDeserializerModifier(new Modifier(mapper));

        mapper.registerModule(module);
        System.out.println(mapper.readValue(JSON, ItemList.class));
    }

}