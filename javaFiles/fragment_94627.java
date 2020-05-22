JSONObject list = new JSONObject(content).getJSONObject("list");
JSONArray resources = list.getJSONArray("resources");
for (int j = 0; j < resources.length(); j++) {
  JSONObject resource = resources.getJSONObject(j).getJSONObject("resource");
  JSONObject fields = resource.getJSONObject("fields");
    if(fields.getString("symbol").equals("XAG=X")){
       System.out.println("Price of symbol(XAG=X) is"+ fields.getString("price"));
    }    
}