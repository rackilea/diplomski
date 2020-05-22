public class JacksonColorTest {

    public static class ColorSerializer extends JsonSerializer<Color> {
        @Override
        public void serialize(Color value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeStartObject();
            gen.writeFieldName("argb");
            gen.writeString(Integer.toHexString(value.getRGB()));
            gen.writeEndObject();
        }
    }

    public static class ColorDeserializer extends JsonDeserializer<Color> {
        @Override
        public Color deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            TreeNode root = p.getCodec().readTree(p);
            TextNode rgba = (TextNode) root.get("argb");
            return new Color(Integer.parseUnsignedInt(rgba.textValue(), 16), true);
        }
    }

    public static void main(String [] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addSerializer(Color.class, new ColorSerializer());
        module.addDeserializer(Color.class, new ColorDeserializer());
        objectMapper.registerModule(module);

        Color testColor = new Color(1, 2, 3, 4);
        String json = objectMapper.writeValueAsString(testColor);
        Color backToObject = objectMapper.readValue(json, Color.class);

        if (!testColor.equals(backToObject)) {
            throw new AssertionError("round trip failed");
        }
    }
}