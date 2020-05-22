private String getAllNames(String result){
        StringBuilder names = new StringBuilder();
        try{
            JSONArray users = new JSONArray(result);
            for(int i = 0; i<users.length();i++){
                JSONObject user = users.getJSONObject(i);
                names.append(user.getString("name")).append("\n");
          }
        }catch(JSONException ex){
            Log.d("Debug","Error parsing json " + ex.getMessage());
        }
        return names.toString();
    }