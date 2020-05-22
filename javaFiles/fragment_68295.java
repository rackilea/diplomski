String json = "{'data':[{'name':'Wallace'},{'name':'Grommit'}]}";
JSONArray jsonArray = (JSONArray) net.sf.json.JSONSerializer.toJSON(json);
for (int i = 0; i < jsonArray.size(); i++) {
   JSONObject jsonObject = (JSONObject) jsonArray.get(i);
   BeanA bean = (BeanA) JSONObject.toBean( jsonObject, BeanA.class );
   //do whatever you want with each object
}