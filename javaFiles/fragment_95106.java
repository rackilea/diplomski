try
{
    JSONObject object = new JSONObject(response);
    String refresh_token = object.getString("refresh_token");

}catch (JSONException e) {
    e.printStackTrace();
}