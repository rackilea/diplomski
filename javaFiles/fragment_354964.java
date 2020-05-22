JSONObject data;
try {
    JSONParser helper = new JSONParser();
    data = (JSONObject)helper.parse(String);
} catch (ParseException parse) {
    // Invalid syntax
    return;
}
// Note that these may throw several exceptions
JSONObject node = (JSONObject)data.get("verb");
JSONArray array = (JSONArray)node.get("syn");