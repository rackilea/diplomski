String jsonString = "{ ... }";
JSONObject json = new JSONObject(jsonString);
JSONArray cargoList = json.getJSONArray("cargo");
for(JSONObject cargo : cargoList)
{
   //do something with your cargo element
}