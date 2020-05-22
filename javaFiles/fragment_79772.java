public class AppConfigDeserializer implements JsonDeserializer<List<Config>> {

 /**
  * Creates an collection of {@link Config}.
  * 
  * <p>If the stringified json element represents a json array as in {@code [{'foo': 'bar'}]}, then
  * the serialized instance will be an instance of {@link JsonArray} comprising of
  * {@link JsonObject}
  * 
  * <p>If th stringified json element represents a json object as in {@code {'foo': 'bar'}}, then
  * the serialized instance will be an instance of {@link JsonObject). 
  * 
  */
  @Override
  public List<Config> deserialize(JsonElement json, Type typeOfT,
      JsonDeserializationContext context) throws JsonParseException {
    json = Objects.requireNonNull(json);
    List<Config> configs = new ArrayList<>();
    if (JsonArray.class.isAssignableFrom(json.getClass())) {
        JsonArray jsonArray = (JsonArray) json;
        for (JsonElement jsonElement : jsonArray) {
          JsonObject jsonObject = (JsonObject) jsonElement.getAsJsonObject();
          // Initialize the list of models with values to defaulting to primitive values.
          configs.add(
          new Config(
              jsonObject.get("appName") != null ?
                  jsonObject.get("appName").getAsString() : null,
              jsonObject.get("propertyName") != null ?
                  jsonObject.get("propertyName").getAsString() : null,
              jsonObject.get("propertyValue") != null ?
                  jsonObject.get("propertyValue").getAsString() : null,
              jsonObject.get("propertyDescription") != null ?
                  jsonObject.get("propertyDescription").getAsString() : null,
              jsonObject.get("editable") != null ?
                  jsonObject.get("editable").getAsBoolean() : false,
              jsonObject.get("updated") != null ?
                jsonObject.get("updated").getAsBoolean() : false));
        }
    } else if (JsonObject.class.isAssignableFrom(json.getClass())) {
      // Just a simple json string.
      JsonObject jsonObject = (JsonObject) json.getAsJsonObject();
      configs.add(new Config(
                jsonObject.get("appName") != null ?
                    jsonObject.get("appName").getAsString() : null,
                jsonObject.get("propertyName") != null ?
                    jsonObject.get("propertyName").getAsString() : null,
                jsonObject.get("propertyValue") != null ?
                    jsonObject.get("propertyValue").getAsString() : null,
                jsonObject.get("propertyDescription") != null ?
                    jsonObject.get("propertyDescription").getAsString() : null,
                jsonObject.get("editable") != null ?
                    jsonObject.get("editable").getAsBoolean() : false,
                jsonObject.get("updated") != null ?
                  jsonObject.get("updated").getAsBoolean() : false));
  }
    return configs;
  }

}