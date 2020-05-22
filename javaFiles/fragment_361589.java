JSONArray jArray = new JSONArray(response);       
 for (int i = 0; i < jArray.length(); i++) {
      JSONObject object = jArray.optJSONObject(i);
      Iterator<String> iterator = object.keys();
      while(iterator.hasNext()) {
        String currentKey = iterator.next();
      }
 }