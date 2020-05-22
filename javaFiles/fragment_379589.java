String jsonAdd = mapper.writeValueAsString(additional);
 String jsonEvent = mapper.writeValueAsString(event);

 JSONObject jsonAddObj = new JSONObject(jsonAdd);
 JSONObject JsonEventObj = new JSONObject(jsonEvent);
 JSONObject finalJson = Merge.deepMerge(jsonAddObj, JsonEventObj);