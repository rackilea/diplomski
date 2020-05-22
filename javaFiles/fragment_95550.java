public class QuotedArrayDeserializer extends JsonDeserializer<int[]> {

    @Override
    public int[] deserialize(JsonParser jp, 
                             DeserializationContext ctxt) throws IOException {
        String rawValue = jp.getValueAsString();
        String[] values = rawValue.replace("[", "").replace("]", "").split(",");
        return Arrays.stream(values).mapToInt(Integer::parseInt).toArray();
    }
}