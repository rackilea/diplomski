JSONObject stops = new JSONObject(); 
   JSONObject arrivals = new JSONObject();
   JSONArray arrivalMoFr  = new JSONArray();

for (Entry<String, List<String>> entry : map.entrySet()) {
    String key = entry.getKey();
    List<String> timeEntries = entry.getValue();                        
    try {                       
         stops.put("stops_name", key);



         JSONArray timeArray = new JSONArray(timeEntries);
         arrivalMoFr.put( timeArray);

         arrivals.put("mon-fri", arrivalMoFr);

         stops.put("arrival_time", arrivals);

         System.out.println(stops.toString(3));
    } catch (JSONException e) {
         e.printStackTrace();
    }
}