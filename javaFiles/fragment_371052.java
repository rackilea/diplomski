String response = "result": 1, "data": [{ "id": 1, "name": "Aconitum", "url": "http://i1.wp.com/cottagegardenflowershop.co.uk/wp-content/uploads/2014" } 
JSONArray data = response.optJSONArray("data");
for (int i =0;i<data.length();i++){
 JSONObject jsonObject = data.getJSONObject(i);
//save this url in a list or however you want to use it
    String url = jsonObject.getString("url");
}