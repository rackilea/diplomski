final class SpecialJsonSerializer<T>
        implements JsonSerializer<T> {

    private final Gson gson; // Unfortunately, Gson does not provide much from JsonSerialiationContext, so we have to get it ourselves
    private final Iterable<String> excludeIfNull;

    private SpecialJsonSerializer(final Gson gson, final Iterable<String> excludeIfNull) {
        this.gson = gson;
        this.excludeIfNull = excludeIfNull;
    }

    static <T> JsonSerializer<T> getSpecialJsonSerializer(final Gson gson, final Iterable<String> excludeIfNull) {
        return new SpecialJsonSerializer<>(gson, excludeIfNull);
    }

    @Override
    public JsonElement serialize(final T object, final Type type, final JsonSerializationContext context) {
        // context.serialize(person, type) cannot work due to infinite recursive serialization
        // therefore the backing Gson instance is used
        final JsonObject jsonObject = gson.toJsonTree(object, type).getAsJsonObject();
        for ( final String propertyName : excludeIfNull ) {
            final JsonElement property = jsonObject.get(propertyName);
            if ( property != null && property.isJsonNull() ) {
                jsonObject.remove(propertyName);
            }
        }
        return jsonObject;
    }

}