JSONObject obj = new JSONObject(str);
//first get the top-level "lists"
JSONArray jsonMainArr = obj.getJSONArray("lists");
for (int i = 0; i < jsonMainArr.length(); i++) { 
   JSONObject childJSONObject = jsonMainArr.getJSONObject(i);
   String name = childJSONObject.getString("name");
   Toast.makeText(context, name, Toast.LENGTH_SHORT).show();
   //get the inner "list" from childJSONObject
   JSONArray childJSONArray = childJSONObject.getJSONArray("list"); 
   for (int j = 0; j < childJSONArray.length(); j++) {
      JSONObject childJSONObjectB = childJSONArray.getJSONObject(j);
      String name = childJSONObjectB.getString("name");
      Toast.makeText(context, name, Toast.LENGTH_SHORT).show();
   }
}