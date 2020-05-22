public final class JsonNullAwareDeserializer
    extends JsonNodeDeserializer
{
    @Override
    public JsonNode getNullValue()
    {
        return NullNode.getInstance();
    }
}