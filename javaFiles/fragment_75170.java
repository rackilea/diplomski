List<String> platformLst = new ArrayList<String>();
List<String> versionLst = new ArrayList<String>();
JSONArray array = obj.getJSONArray("France24");
for(int i = 0 ; i < array.length() ; i++){
    JSONObject obj = array.getJSONObject(i);
    versionLst.add(obj.getString("platform"));
    platformLst .add(obj.getString("version"));
}