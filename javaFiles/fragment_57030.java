public <T> T deserialise(String payload, Class<T> expectedClass) {
    Objects.requireNonNull(payload);
    Objects.requireNonNull(expectedClass);

    try {
        return mapper.readValue(payload, expectedClass);
    } catch (IOException e) {
        throw new IllegalStateException("JSON is not valid!", e);
    }
}