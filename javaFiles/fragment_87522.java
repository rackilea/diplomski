...
public <T> T fromPubSubMessage(PubsubMessage message, Class<T> payloadType) {
    try {
        String payload = message.getData().toStringUtf8();
        payload = removeQuotesIfNecessary(unescapePayload(payload));
        return (T) this.objectMapper.readerFor(payloadType).readValue(payload);
    }
    catch (IOException ex) {
        throw new PubSubMessageConversionException("JSON deserialization of an object of type " + payloadType.getName() + " failed.", ex);
    }
}

private String removeQuotesIfNecessary(String payload) {
    if (payload != null && payload.startsWith("\"") && payload.endsWith("\"")) {
        return payload.substring(1).substring(0, payload.length()-2);
    }
    return payload;
}

private String unescapePayload(String payload) {
    if (payload != null)
        return StringEscapeUtils.unescapeJson(payload);
    return payload;
}