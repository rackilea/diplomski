public boolean isJSONValid(String jsonStr) {
    try {
        new JSONObject(jsonStr);
    } catch (JSONException ex) {
        return false;
    }
    return true;
}