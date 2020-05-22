public JSONArray getJsonParam(){
JSONArray jsonArray=new JSONArray();

for(int i=0;i<dataArray.length();i++)
jsonArray.put(dataArray[i]);

return jsonArray;
}