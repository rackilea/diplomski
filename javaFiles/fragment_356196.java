JSONObject obj = new JSONObject("Content of your string here");
JSONArray rows = obj.getJSONArray("rows");
for (int i = 0; i < rows.length(); i++) {
 JSONArray elements = rows.getJSONObject(i).getJSONArray("elements");
  for(int j = 0; j < elements.length(); j++) {
   JSONObject element = elements.getJSONObject(j);
   JSONObject duration = element.getJSONObject("duration");
   int value = duration.getInt("value");
  }
 }