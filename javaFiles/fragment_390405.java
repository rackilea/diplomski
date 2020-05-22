private static List<String> jsonToList(String json){
    List<String> list = new ArrayList<>();
    Gson gson = new Gson();
    Type type = new TypeToken<Map<String, Object>>(){}.getType();
    Map<String, Object> jsonMap = gson.fromJson(json, type);
    Map<String, Object> flatten = FlatMapUtil.flatten(jsonMap);
    flatten.forEach((k, v) -> list.add(v.toString()));
    return list;
}