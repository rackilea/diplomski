public static Map<String, Object> getMapFromObject(Object o) {
    Gson gson = new Gson();
    Type stringObjectMap = new TypeToken<Map<String, Object>>() {
     }.getType();
    return gson.fromJson(gson.toJson(o), stringObjectMap);
}