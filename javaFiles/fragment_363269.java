// write
JSONObject json = new JSONObject();
json.put("u", mp);
JSONArray mealplan_json = new JSONArray();
mealplan_json.put(...); // fill arrays recursively
json.put("m", mealplan_json);
String text = json.toString();

// read
JSONObject json = new JSONObject(text);
mp = json.getString("u");
JSONArray mealplan_json = json.getJSONArray("m");
...