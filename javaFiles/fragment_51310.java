public class UriDeserializer implements JsonDeserializer<Uri> {
  @Override
  public Uri deserialize(final JsonElement src, final Type srcType,
      final JsonDeserializationContext context) throws JsonParseException {
    return Uri.parse(src.getAsString());
  }
}