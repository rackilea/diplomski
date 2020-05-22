public class NullAwareJsonObjectBuilder implements JsonObjectBuilder {
    // Use the Factory Pattern to create an instance.
    public static JsonObjectBuilder wrap(JsonObjectBuilder builder) {
      if (builder == null) {
        throw new IllegalArgumentException("Can't wrap nothing.");
      }
      return new NullAwareJsonObjectBuilder(builder);
    }

    // Decorated object per Decorator Pattern.
    private final JsonObjectBuilder builder;

    private NullAwareJsonObjectBuilder(JsonObjectBuilder builder) {
      this.builder = builder;
    }

    public JsonObjectBuilder add(String name, JsonValue value) {
      builder.add(name, (value == null) ? JsonValue.NULL : value);
    }

    // Implement all other JsonObjectBuilder methods.
    ..
}