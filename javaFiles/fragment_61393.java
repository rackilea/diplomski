static class MapCustomDeserializerModifier extends BeanDeserializerModifier {

  @Override
  public JsonDeserializer<?> modifyMapDeserializer(DeserializationConfig config, MapType type, BeanDescription beanDesc, JsonDeserializer<?> deserializer {

    final JsonDeserializer<?> jsonDeserializer = super.modifyMapDeserializer(config, type, beanDesc, deserializer);
    if (type.getKeyType().isTypeOrSubTypeOf(String.class) && type.getContentType().isTypeOrSubTypeOf(String.class)) {
      return new MapCustomDeserializer();
    }

    return jsonDeserializer;
  }

}

static class MapCustomDeserializer extends JsonDeserializer<Map<String, String>> {

  @Override
  public Map<String, String> deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException, JsonProcessingException {

    final Map<String, String> map = jsonParser.readValueAs(Map.class);

    if (map != null) {
      map.replaceAll((key, value) -> Strings.nullToEmpty(value));
    }
    return map;
  }
}