JSONObject obj = new JSONObject("{interests : [{interestKey:Dogs}, {interestKey:Cats}]}");

List<String> list = new ArrayList<String>();
JSONArray array = obj.getJSONArray("interests");
for(int i = 0 ; i < array.length() ; i++){
    list.add(array.getJSONObject(i).getString("interestKey"));
}