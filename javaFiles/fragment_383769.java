Object object = new JSONTokener(jsonString).nextValue();

if (object instanceof JSONObject) 
{
  JSONObject jsonObject = (JSONObject) object;
}
else  if (object instanceof JSONArray)
{
  JSONArray jsonArray = (JSONArray) object;
}