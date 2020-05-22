try {
    JSONArray jsonArray = new JSONArray(response);
    for (int i = 0; i < jsonArray.length(); i++) {
         //  use optJSONObject
         JSONObject author = jsonArray.optJSONObject(i).optJSONObject("author");
         // use optString , it did not return null
         String profile_photo = author.optString("profile_photo");
         String primary_photo = jsonArray.optJSONObject(i).optString("primary_photo");
    }
} catch (JSONException e) {
        e.printStackTrace();
}