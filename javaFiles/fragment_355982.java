@Override
public void onMessageReceived(String from, Bundle data) {
    try {
        JSONObject myData = new JSONObject(data.getString("myData"));
    } catch (JSONException e){}
}