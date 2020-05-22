public void loadJsonObjectAsArray() throws IOException {
    String data = "{\"x:y\":1,\"x:z\":2,\"u:v\":3}";
    ObjectMapper mapper = new ObjectMapper();
    Wrapper wrapper = mapper.readValue(data, Wrapper.class);
    List<MyClass> out = wrapper.values;
    System.out.println(out);
}

public static class WrapperDeserializer extends StdDeserializer<Wrapper> {
    public WrapperDeserializer() {
        this(null);
    }

    public WrapperDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Wrapper deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        JsonNode node = jp.getCodec().readTree(jp);
        ObjectNode obj = (ObjectNode) node;
        List<MyClass> parsedFields = new ArrayList<>();

        obj.fields().forEachRemaining(fieldAndNode -> {
            String fieldName = fieldAndNode.getKey();
            Number value = fieldAndNode.getValue().numberValue();
            parsedFields.add(new MyClass(fieldName, value));
        });

        return new Wrapper(parsedFields);
    }
}

private static class MyClass {
    String first;
    String second;
    Number value;

    public MyClass(String both, Number value) {
        String[] split = both.split(":");
        first = split[0];
        second = split[1];
        this.value = value;
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "first='" + first + '\'' +
                ", second='" + second + '\'' +
                ", value=" + value +
                '}';
    }
}

@JsonDeserialize(using = WrapperDeserializer.class)
private static class Wrapper {
    private final List<MyClass> values;

    public Wrapper(List<MyClass> values) {
        this.values = new ArrayList<>(values);
    }
}