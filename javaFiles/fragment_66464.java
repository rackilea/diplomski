Map<String, Object> dataMap = new HashMap<>();
JSONObject data = (JSONObject) inputJsonObj.get("data");
Set<String> keys = data.keySet();
for (String key : keys) {
     if(data.get(key) instanceof String) {
          dataMap.put(key, data.get(key));
     } else if(data.get(key) instanceof JSONObject) {
         // handle this by creating a new Map and store it in the original map.
         Map<String, Object> summaryMap = new HashMap<>();
         // Iterate over your summary and store it as key value pairs in summaryMap. 
         // You can have this functionality recursive if you are expecting multi-level json. 
         dataMap.put(key, summaryMap);
     }
 }