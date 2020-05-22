JSONArray checkArray = obj.getJSONArray("checkArray");
JSONObject checkObj;
for (int itemIndex=0, totalObject = checkArray.length(); itemIndex < totalObject; itemIndex++) {     
    checkObj = checkArray.getJSONObject(itemIndex);
    int ptchkNumber = checkObj.getInt("ptchkNumber");
}