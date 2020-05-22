@Override
public void onResponse(JSONObject response) {
    try {
        JSONObject userObj = response.getJSONObject("UserInfo")
                            .getJSONObject("User");
        String name = userObj.getString("name");
        ...
    } catch (JSONException jsEx) {
        jsEx.printStackTrace();
    }

}