JSONObject outerObject = new JSONObject();
JSONArray outerArray = new JSONArray();

JSONObject [] innerObject = new JSONObject[4];
for(int i =0; i<3; i++)
{
    innerObject[i]=new JSONObject();
    innerObject[i].put("id", "id of "+i);
    innerObject[i].put("url", "url of "+i);
    innerObject[i].put("Definition", "Definition of "+i);
    outerArray.put(innerObject[i]);
}
outerObject.put("rows", outerArray);
return outerObject.toString();