String localPhoneStr = _allPeoplesDictArr.get(j).get("PhoneNumbers");
JSONArray phoneArray = new JSONArray(localPhoneStr);

for(int i=0; i<phoneArray.length(); i++){

    JSONObject phone = phoneArray.getJSONObject(i);

    userDict.put("label", phone.getString(String.format("Label_%d", i)));
    userDict.put("value", phone.getString(String.format("Phone_%d", i)));
}