Object[] IEXDivMap = new Object[IEXJsonArray.length()];

for (int i = 0; i < IEXJsonArray.length(); i++) {
    IEXDivMap[i] = new HashMap();
    JSONObject IEXJsonObject = IEXJsonArray.getJSONObject(i);

    IEXDivMap[i].put("exDate",IEXJsonObject.getString("exDate")); // this fails
    IEXDivMap[i].put("amount",IEXJsonObject.getString("amount"));

    ((Map) IEXDivMap[i]).put("exDate",IEXJsonObject.getString("exDate")); // this works
    ((HashMap) IEXDivMap[i]).put("exDate",IEXJsonObject.getString("exDate")); // this works           

}