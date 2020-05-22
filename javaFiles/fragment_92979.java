JSONObject json = new JSONObject(jsonString);
JSONArray jArray = json.getJSONArray("list");

System.out.println("*****JARRAY*****" + jArray.length());

for(int i=0; i<jArray.length(); i++){
    JSONObject json_data = jArray.getJSONObject(i);

    Log.i("log_tag", "_id" + json_data.getInt("account") +
        ", mall_name" + json_data.getString("name") +
        ", location" + json_data.getString("number") +
        ", telephone" + json_data.getString("url") +
        ",----" + json_data.getString("balance") +
        ",----" + json_data.getString("credit") +
        ",----" + json_data.getString("displayName")
    );
}