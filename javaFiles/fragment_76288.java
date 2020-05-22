String response = "{\"error\":{\"phone\":[\"The phone field is required.\"]}}";

try {
    JSONObject jsonObject = new JSONObject(response);
    JSONObject errorObject = jsonObject.optJSONObject("error");
    JSONArray phoneArray = errorObject.getJSONArray("phone");

    for (int i = 0; i < phoneArray.length(); i++) {
        String  errorString = phoneArray.optString(i);
        Log.d("OutPut", errorString);
    }
} catch (JSONException e) {
    e.printStackTrace();
}