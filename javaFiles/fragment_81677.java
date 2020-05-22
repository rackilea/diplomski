public class PairSerializer implements JsonSerializer<Pair> {

    public PairSerializer() {
        super();
    }

    @Override
    public JsonElement serialize(final Pair value, final Type type,
            final JsonSerializationContext context) {
        final JsonObject jsonObj = new JsonObject();
        jsonObj.add("first", context.serialize(value.getFirst()));
        jsonObj.add("second", context.serialize(value.getSecond()));

        return jsonObj;
    }
}