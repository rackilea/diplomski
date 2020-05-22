ArrayList<HashMap<String, String>> dataMap = new ArrayList<HashMap<String, String>>();

HashMap<String, String> data1 = new HashMap<String, String>();
data1.put("image", "2130837526");
data1.put("category", "Chairs");
data1.put("Quantity", "1");

HashMap<String, String> data2 = new HashMap<String, String>();
data2.put("image", "2130837566");
data2.put("category", "Mirrors");
data2.put("Quantity", "2");

dataMap.add(data1);
dataMap.add(data2);


List<JSONObject> jsonObj = new ArrayList<JSONObject>();

for(HashMap<String, String> data : dataMap) {
    JSONObject obj = new JSONObject(data);
    jsonObj.add(obj);
}

JSONArray test = new JSONArray(jsonObj);

System.out.println(test.toString());