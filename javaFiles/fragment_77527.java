class MillisOrLocalDateTimeDeserializer extends LocalDateTimeDeserializer {

    public MillisOrLocalDateTimeDeserializer() {
        super(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

    @Override
    public LocalDateTime deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        if (parser.hasToken(JsonToken.VALUE_NUMBER_INT)) {
            long value = parser.getValueAsLong();
            Instant instant = Instant.ofEpochMilli(value);

            return LocalDateTime.ofInstant(instant, ZoneOffset.UTC);
        }

        return super.deserialize(parser, context);
    }

}