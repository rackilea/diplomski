JSONObject responseObj = new JSONObject(responseString);
String result = responseObject.get("result");
if(result.equalsIgnoreCase("ok") 
{ /* handle good case */ 
    JSONArray list = (JSONArray)responseObj.get("data");
    for(...) {}
}
else { /* handle error case*/ }