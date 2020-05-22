try {
    Request friendsRequest = new Request(session, "/me/friends");
    Response response = friendsRequest.executeAndWait();
    JSONObject responseJSON = new JSONObject(response.getRawResponse());
    JSONArray data = responseJSON.getJSONArray("data");
    if (data.length() > 0) {
        for (int i = 0; i < data.length(); i++) {
            JSONObject friend = (JSONObject) data.get(i);
            String name = friend.getString("name");
            String facebookID = friend.getString("id");

            // Do Stuff With name and facebookID

        }
    }
} catch (JSONException e) {
    e.printStackTrace();
} catch (FacebookException e) {
    e.printStackTrace();
}