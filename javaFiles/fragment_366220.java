JSONArray json = new JSONArray(server_response);
ArrayList<String> list = new ArrayList<String>();

for(int i = 0; i < json.length(); ++i){
    try{
        String uid = json.getJSONObject(i).getString("uid");
        list.add(uid);
    }
    catch(JSONException e){}
}