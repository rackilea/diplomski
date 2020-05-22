private static List<? extends Item> getDatalsomJson(String jsonString) {
    Type type = new TypeToken<List<? extends JsonResponse.Item>>(){}.getType();
    GsonBuilder gb = new GsonBuilder();
    gb.registerTypeAdapter(type, new JsonResponse.JsonResponseDeserialize());
    Gson gson = gb.create();
    List<? extends Item> ls = gson.lsomJson(jsonString, type);
    return ls;
}