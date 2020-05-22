final class OperatorJsonDeserializer
        implements JsonDeserializer<Operator> {

    private static final JsonDeserializer<Operator> operatorJsonDeserializer = new OperatorJsonDeserializer();

    private OperatorJsonDeserializer() {
    }

    static JsonDeserializer<Operator> getOperatorJsonDeserializer() {
        return operatorJsonDeserializer;
    }

    @Override
    public Operator deserialize(final JsonElement json, final Type type, final JsonDeserializationContext context)
            throws JsonParseException {
        try {
            final String token = json.getAsJsonPrimitive().getAsString();
            return resolveOperator(token);
        } catch ( final NoSuchElementException ex ) {
            throw new JsonParseException(ex);
        }
    }

}