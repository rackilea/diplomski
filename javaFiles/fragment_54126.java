public class JacksonSerializer {

    public static final String INPUT = "{\n" +
            "    \"menu\": [\n" +
            "        {\n" +
            "            \"1\": \"sql\",\n" +
            "            \"2\": \"android\",\n" +
            "            \"3\": \"mvc\"\n" +
            "        }\n" +
            "    ]\n" +
            "}";

    public static class MenuItems {

        Map<String, String> menu = Maps.newHashMap();
    }


    public static class MenuItemsDeserializer extends JsonDeserializer<MenuItems> {


        @Override
        public MenuItems deserialize(org.codehaus.jackson.JsonParser jsonParser,
                                               DeserializationContext deserializationContext)
                throws IOException, JsonProcessingException {

            JsonNode node = jsonParser.getCodec().readTree(jsonParser);

            final JsonNode elems = node.getElements().next().getElements().next();
            final Map<String, String> map = Maps.newHashMap();
            final Iterator<Map.Entry<String, JsonNode>> it = elems.getFields();
            while (it.hasNext()) {
                final Map.Entry<String, JsonNode> entry = it.next();
                map.put(entry.getKey(), entry.getValue().asText());
            }                

            final MenuItems menuItems = new MenuItems();
            menuItems.menu = map;
            return menuItems;
        }
    }

    public static void main(final String[] args) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule("SimpleModule",
                new Version(1,0,0,null));
        module.addDeserializer(MenuItems.class, new MenuItemsDeserializer());
        mapper.registerModule(module);

        MenuItems menuItems = mapper.readValue(INPUT, MenuItems.class);

    }
}