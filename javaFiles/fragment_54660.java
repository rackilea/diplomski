@Override
public Boolean deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException {
    JsonNode node = jp.getCodec().readTree(jp);
    return node.size() != 0;
}