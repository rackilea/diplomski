private static List<String> jsonToList(String json) {
    JSONObject response = new JSONObject(json);
    List<String> list = new ArrayList<>();
    JSONArray jsonArray = response.getJSONArray("categories");
    if (jsonArray != null) {
        for (int i = 0; i < jsonArray.length(); i++) {
            list.add(jsonArray.get(i).toString());
        }
    }
    return list;
}