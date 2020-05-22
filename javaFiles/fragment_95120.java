public static class EventsSearchResponseSerializer extends JsonSerializer<EventsSearchResponse>
{
    @Override
    public void serialize(EventsSearchResponse res, JsonGenerator gen, SerializerProvider serializers)
            throws IOException, JsonProcessingException
    {
        gen.writeStartObject();

        for (MapEntryType t : res.mapEntries) {
            gen.writeObjectField(t.key, t.value);
        }
        gen.writeEndObject();
    }
}