// Your Existing JSONArray
// [{"id":1,"name":"example1","description":"An example"},
//  {"id":2,"name":"example2","description":"Just another example"},
//  {"id":3,"name":"example3","description":"Third example"}]  

String jsonDataString = "[{\"id\":1,\"name\":\"example1\",\"description\":\"An example\"},{\"id\":2,\"name\":\"example2\",\"description\":\"Just another example\"},{\"id\":3,\"name\":\"example3\",\"description\":\"Third example\"}]";

try {

    JSONArray jsonArray = new JSONArray(jsonDataString);

    Log.d("JSON", "JSON before Remove: " + jsonArray.toString());

    // Remove Object id = 2
    int removeId = 2;

    for (int i = 0; i < jsonArray.length(); i++)
    {
        JSONObject object = jsonArray.getJSONObject(i);

        if (object.has("id") && !object.isNull("id")) {

            int id = object.getInt("id");

            if (id == removeId)
            {
                jsonArray.remove(i);
                break;
            }
        }
    }

    Log.d("JSON", "JSON After Remove: " + jsonArray.toString());

} catch (final JSONException e) {
    Log.e("FAILED", "Json parsing error: " + e.getMessage());
}