public class JacksonForUpdate2 {

    public static class Bean {
        private String name;
        private Map<String, Object> properties;

        public void setName(String name) {
            this.name = name;
        }

        @JsonCreator
        public Bean(JsonNode node, @JacksonInject ObjectMapper mapper) throws IOException {
            this.properties = mapper.convertValue(node, Map.class);
            mapper.readerForUpdating(this).readValue(node);
        }

        @Override
        public String toString() {
            return "Bean{" +
                    "name='" + name + '\'' +
                    ", properties=" + properties +
                    '}';
        }
    }
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        // make the mapper to be available for the bean
        mapper.setInjectableValues(new InjectableValues.Std().addValue(ObjectMapper.class, mapper));
        final String json = "[{\"name\":\"value\"},{\"name\":\"value2\"}]";
        System.out.println( mapper.readValue(json, new TypeReference<List<Bean>>() {}));
    }
}