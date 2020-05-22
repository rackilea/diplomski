JSONObject jsonObject = new JSONObject(approvec).getJSONObject("data");
JSONArray ids = jsonObject.names();
List < String > returnIds = new ArrayList < > ();
for (int i = 0; i < ids.length(); i++) {
    String id = ids.getString(i);
    if (jsonObject.getJSONObject(id).getBoolean("qualify"))
        returnIds.add(id);
}

return returnIds;