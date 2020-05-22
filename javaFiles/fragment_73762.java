public class CustomLocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {

    @Override
    public LocalDateTime deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException {

        JsonNode tree = jp.getCodec().readTree(jp);
        int year = tree.get("year").asInt();
        int month = tree.get("monthValue").asInt();
        int dayOfMonth = tree.get("dayOfMonth").asInt();
        int hour = tree.get("hour").asInt();
        int minute = tree.get("minute").asInt();
        int second = tree.get("second").asInt();
        int nano = tree.get("nano").asInt();

        return LocalDateTime.of(year, month, dayOfMonth, hour, minute, second, nano);
    }
}