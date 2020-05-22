public class JacksonArrayAsMap {

    public static class Bean {
        private Map<String, Object> value;

        public void setValue(Object value) {
            if (value instanceof Map) {
                this.value = (Map<String, Object>) value;
            } else if (value instanceof List && ((List) value).size() == 0){
                this.value = Collections.EMPTY_MAP;
            } else {
                throw new IllegalArgumentException("Invalid value: " + value);
            }
        }

        @Override
        public String toString() {
            return "Bean{" +
                    "value=" + value +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        final String json1 = "{\"value\":{}}";
        final String json2 = "{\"value\":[]}";
        final String json3 = "{\"value\":{\"a\":\"b\"}}";
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.readValue(json1, Bean.class));
        System.out.println(mapper.readValue(json2, Bean.class));
        System.out.println(mapper.readValue(json3, Bean.class));
    }
}