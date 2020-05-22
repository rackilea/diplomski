JSONObject jsonObject = new JSONObject(jsonString);
JSONArray friends = jsonObject.getJSONArray("data");
for (int index=0; index<friends.length(); ++index){
        JSONObject currentFriend = friends.getJSONObject(index);
        String id = currentFriend.getString("id");
}