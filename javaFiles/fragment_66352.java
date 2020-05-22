JSONArray playerData;
JSONObject playerJson = parseJSON("http://logs.tf/json_search?player=" + steamID64).get("logs");
if (playerJson instanceof JSONArray) {
    playerData = (JSONArray) playerJson;
} else {
    throw new IllegalStateException("wrong Json type " + playerJson)
}