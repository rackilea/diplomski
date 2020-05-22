// Your Existing JSONArray
// [{"id":1,"name":"example1","description":"An example"},
//  {"id":2, "name":"example2","description":"Just another example"}]

String jsonDataString = "[{\"id\":1,\"name\":\"example1\",\"description\":\"An example\"},{\"id\":2,\"name\":\"example2\",\"description\":\"Just another example\"}]";

try {

    JSONArray jsonArray = new JSONArray(jsonDataString);

    // Object 3
    JSONObject jsonObject3 = new JSONObject();
    jsonObject3.put("id", 3);
    jsonObject3.put("name", "example3");
    jsonObject3.put("description", "Third example");

    // Add Object 3 JSONArray
    jsonArray.put(jsonObject3);

    Log.d("JSON", "JSON: " + jsonArray.toString());

} catch (final JSONException e) {
    Log.e("FAILED", "Json parsing error: " + e.getMessage());
}