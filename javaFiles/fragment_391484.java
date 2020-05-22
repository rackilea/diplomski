JSONArray arr = new JSONArray(jstring);
for (int i = 0; i < arr.length(); i++) { // Walk through the Array.
    JSONObject obj = arr.getJSONObject(i);
    JSONArray arr2 = obj.getJSONArray("fileName");
    // Do whatever.
}