private static final Gson gson = new Gson();

static Data testUsingJsonTreesOnly(final Reader reader) {
    final List<MyObject> objects = StreamSupport.stream(gson.fromJson(reader, JsonElement.class).getAsJsonArray().spliterator(), false)
            .map(JsonElement::getAsJsonObject)
            .map(jsonObject -> jsonObject.get("data"))
            .filter(Objects::nonNull)
            .map(JsonElement::getAsJsonObject)
            .map(jsonObject -> jsonObject.get("value"))
            .filter(Objects::nonNull)
            .map(JsonElement::getAsJsonObject)
            .map(jsonObject -> jsonObject.get("instruments"))
            .filter(Objects::nonNull)
            .map(JsonElement::getAsJsonPrimitive)
            .map(JsonPrimitive::getAsString)
            .map(json -> gson.fromJson(json, JsonElement.class))
            .map(JsonElement::getAsJsonArray)
            .flatMap(jsonArray -> StreamSupport.stream(jsonArray.spliterator(), false))
            .map(jsonElement -> gson.fromJson(jsonElement, MyObject.class))
            .collect(toList());
    return new Data(objects);
}