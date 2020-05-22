List<JSONObject> list = new ArrayList<JSONObject>();
try {
    int i;
    JSONArray array = new JSONArray(string);
    for (i = 0; i < array.length(); i++)
        list.add(array.getJSONObject(i);
} catch (JSONException e) {
    System.out.println(e.getMessage());
}