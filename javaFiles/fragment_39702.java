try {
    JSONArray rootArray = new JSONArray(inputJSON);
    JSONObject firstJSONObj = rootArray.getJSONObject(0);
    System.out.println(
        firstJSONObj.getJSONObject("user").getString("displayName") // prints "usuario"
    );
} catch (JSONException e) {
    e.printStackTrace();
}