@JsonIgnoreProperties(
        ignoreUnknown = true
    )
    @JsonDeserialize(
        using = IdTextEntry.Deserializer.class
    )
    @Data
    public class IdTextEntry implements IdAndText {
        String id;
        String text;

        public IdTextEntry(Enum<?> val) {
            if (val != null) {
                this.id = val.name();
                this.text = val.toString();
            }

        }        

        public static class Deserializer extends StdDeserializer<IdTextEntry> {
            public Deserializer() {
                this((Class)null);
            }

            Deserializer(Class<?> vc) {
                super(vc);
            }

            public IdTextEntry deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
                JsonNode node = (JsonNode)jp.getCodec().readTree(jp);
                String id;
                if (node.has("id") && node.has("text")) {
                    id = node.get("id").asText();
                    String text = node.get("text").asText();
                    return new IdTextEntry(id, text);
                } else if (node.has("id")) {
                    id = node.get("id").asText();
                    return new IdTextEntry(id, id);
                } else {
                    id = node.asText();
                    return new IdTextEntry(id, id);
                }
            }
        }
    }