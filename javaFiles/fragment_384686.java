ArrayList<JSONObject> jsonObjects = new ArrayList<JSONObject>();
//ADD objects in the jsonObjects

ArrayList<List<String>> jsonObjectsResultData = new ArrayList<>();
//Loop for the all JSONObject
for (JSONObject jsonObject : jsonObjects){
    String jsonStr = jsonObject.toString();
    String[] strArr = jsonObject.split(",");

    List<String> jsonObjectsValues = new ArrayList<String>();
    for(int i=0;i<strArr.length;i++){
        jsonObjectsValues.add(strArr[i].split(":")[1]);
    }
    jsonObjectsResultData.add(jsonObjectsValues);
}
//Your result array list
Log.i("RESULT DATA >>", jsonObjectsResultData.toString());