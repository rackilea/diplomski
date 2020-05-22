public class JacksonTypeInfoOnObject {

    public static class Bean {
        @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
        @JsonSubTypes({
                @JsonSubTypes.Type(Command1.class),
                @JsonSubTypes.Type(Command2.class)
        })
        public final Object command;

        @JsonCreator
        public Bean(@JsonProperty("command") final Object command) {this.command = command;}

        @Override
        public String toString() {
            return "Bean{" +
                    "command=" + command +
                    '}';
        }
    }

    @JsonTypeName("cmd1")
    public static class Command1 {
        @Override
        public String toString() {
            return "Command1{}";
        }
    }

    @JsonTypeName("cmd2")
    public static class Command2 {
        @Override
        public String toString() {
            return "Command2{}";
        }
    }


    public static void main(String[] args) throws IOException {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        final List<Bean> list = Arrays.asList(
                new Bean(new Command1()),
                new Bean(new Command2()));
        final String json = mapper.writeValueAsString(list);
        System.out.println(json);
        final List<Bean> values = mapper.readValue(json, new TypeReference<List<Bean>>() {});
        System.out.println(values);
    }
}