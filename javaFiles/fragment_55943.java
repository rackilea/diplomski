class IdListAdapter<T> implements JsonDeserializer<List<T>> {

  @Override
  public List<T> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext jsc) throws JsonParseException {

    if (json.isJsonObject()) {
      JsonObject envelope = json.getAsJsonObject();
      JsonArray data = envelope.getAsJsonArray("data");
      return jsc.deserialize(data, typeOfT);
    } else {
      JsonArray idArray = json.getAsJsonArray();
      List<T> result = new ArrayList<T>(idArray.size());
      for (JsonElement id : idArray) {
        if (typeOfT instanceof ParameterizedType) {
          Type parameterType = ((ParameterizedType) typeOfT).getActualTypeArguments()[0];
          JsonObject obj = new JsonObject();
          obj.add("id", id);
          T element = jsc.deserialize(obj, parameterType);
          result.add(element);
        }
      }
      return result;
    }
  }
}