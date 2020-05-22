public static <T> JsonArray getJsonArray(List<T> list){
    if(list.size() == 0) return null;

    Gson gson = new Gson();
    JsonElement element = gson.toJsonTree(list);
    JsonArray jsonArray = element.getAsJsonArray();
    return jsonArray;   
}