try {

    JSONArray jsonArray = new JSONArray();

    // Object 1
    JSONObject jsonObject1 = new JSONObject();
    jsonObject1.put("id", 1);
    jsonObject1.put("name", "example1");
    jsonObject1.put("description", "An example");

    // Object 2
    JSONObject jsonObject2 = new JSONObject();
    jsonObject2.put("id", 2);
    jsonObject2.put("name", "example2");
    jsonObject2.put("description", "Just another example");

    // Add Object 1 & 2 JSONArray
    jsonArray.put(jsonObject1);
    jsonArray.put(jsonObject2);


    Log.d("JSON", "JSON: " + jsonArray.toString());

} catch (final JSONException e) {
    Log.e("FAILED", "Json parsing error: " + e.getMessage());
}