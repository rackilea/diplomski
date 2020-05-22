public <T extends Object> List<T> parameterToList( Map<String,String[]> entity, Class<T> classOfT) {
    Map<String, String[]> collect = entity.entrySet().stream()
            .filter(p -> p.getKey().startsWith(entity))
            .collect(Collectors.toMap(p -> p.getKey().replace(entity + ".", ""), p -> p.getValue()));

    JsonObject requestJson = new JsonObject();
    JsonArray main = new JsonArray();

    Map.Entry<String, String[]> entry1 = collect.entrySet().iterator().next();
    String key = entry1.getKey();
    int size = entry1.getValue().length;

    int i = 0;
    while (i < size) {
        for (Map.Entry<String, String[]> entry : collect.entrySet()) {
            // add every item as a property to the json
            requestJson.addProperty(entry.getKey(), entry.getValue()[i]);
        }
        i = i + 1 ;
        main.add(requestJson);
    } List<T> fromJson = gson.fromJson(main, new TypeToken<List<T>>() {}.getType());

    return fromJson;