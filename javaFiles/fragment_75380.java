JSONObject jsonResult = new JSONObject(result);
JSONArray data = jsonResult.getJSONArray("data");
if(data != null) {
    String[] names = new String[data.length()];
    for(int i = 0 ; i < data.length() ; i++) {
        JSONArray arr = data.getJSONArray(i);
        dataObj = arr.getJSONObject(0)
        Iterator<String> keys = dataObj.keys();
        names[i] = dataObj.getString(keys.next())
    }
    System.out.println(names);
}