JSONObject json = new JSONObject();
json.put("sun","yellow");

JSONArray veg = new JSONArray();
JSONObject vegData = new JSONObject();
vegData.put("apple","red");
vegData.put("banana","yellow");
vegData.put("melon","orange");

veg.put(vegData);   

json.put("vegetables",veg);