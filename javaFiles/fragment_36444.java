String jsonText = "{\"test\":true}"; // or wherever you have your json
JSONObject json = new JSONObject(jsonText);
if (json.has("test")) {
    json.put("test", !json.getBoolean("test"));
} else {
    json.put("test", true);
}