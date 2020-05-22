public class JacksonForUpdate {

    public static class Bean {
        private String name;
        private Map<String, Object> properties;

        public void setName(String name) {
            this.name = name;
        }

        @JsonCreator
        public Bean(Map<String, Object> properties) {
            this.properties = properties;
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
        final String json = "{\"name\":\"value\"}";
        Bean object = mapper.readValue(json, Bean.class);
        System.out.println(mapper.readerForUpdating(object).readValue(json));
    }
}