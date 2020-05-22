JSONArray jArray=new JSONArray(your json string);
for(int i=0;i<(jArray.length());i++)
{
    JSONObject json_obj=jArray.getJSONObject(i);
    String value1=json_obj.getString("key1");
    String value2=json_obj.getString("key2");
}