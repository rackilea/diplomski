JSONArray root = new JSONArray();
for (Entry<String, List<String>> entry : directionMap.entrySet()) {
    JSONObject stop = new JSONObject();
    String stopName = entry.getKey();
    stop.put("stop_name", stopName);

    JSONObject arrivalTime = new JSONObject();
    JSONArray monFriArrivalTime = new JSONArray();
    JSONArray satArrivalTime = new JSONArray();
    JSONArray sunFriArrivalTime = new JSONArray();
    for (String str: entry.getValue()) {
        monFriArrivalTime.add(str);
     }
    for (String str: directionMap2.get(stopName)) {
        satArrivalTime.add(str);
    }
    for (String str: directionMap3.get(stopName)) {
        sunFriArrivalTime.add(str);
    }
    arrivalTime.put("mon-fri", monFriArrivalTime);
    arrivalTime.put("sat", satArrivalTime);
    arrivalTime.put("sun", sunFriArrivalTime);
    stop.put("arrival_time", arrivalTime);          
    root.add(e);
}
System.out.println(root);