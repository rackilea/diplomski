public class FooBar {

    private Set<String> foos = new HashSet<>();
    private Set<String> bars = new HashSet<>();

    @JsonProperty("FooWrapper")
    @JsonSerialize(using = FooCollectionSerializer.class)
    public Set<String> getFoos() {
        return foos;
    }

    @JsonProperty("BarWrapper")
    @JsonSerialize(using = BarCollectionSerializer.class)
    public Set<String> getBars() {
        return bars;
    }

    public static class FooCollectionSerializer extends JsonSerializer<Collection<String>> {

        JsonSerializer<Collection<String>> serializer;

        public FooCollectionSerializer() {
            //let Jackson deal with serializing the collection and just specify how you want to serialize indivial items
            this.serializer = new StringCollectionSerializer(null, new FooSerializer());
        }

        @Override
        public void serialize(Collection<String> value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
            serializer.serialize(value, jgen, provider);
        }
    }

    public static class FooSerializer extends SerializerBase<String> {
        public FooSerializer() {
            super(String.class);
        }

        @Override
        public void serialize(String value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
            jgen.writeString(value);
        }
    }

    public static class BarCollectionSerializer extends JsonSerializer<Collection<String>> {

        @Override
        public void serialize(Collection<String> values, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
            //handle serializing the collection yourself
            jgen.writeStartArray();
            for (String value : values) {
                jgen.writeString(value);

            }
            jgen.writeEndArray();
        }
    }
}