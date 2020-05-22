for (int i = 0; i < innerProjectarray.length(); i++) {

JSONObject obj = innerProjectarray.getJSONObject(i);

String projNum = obj.optString("code"); 
String projName = obj.optString("Picture_ID"); 
// and use both values. 
}