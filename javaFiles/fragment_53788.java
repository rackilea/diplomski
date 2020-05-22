String jsonSource = /* your json string */;
JSONArray array = new JSONArray(jsonSource);
for (int i = 0; i < array.length(); i++) {
    JSONObject firstObject = (JSONObject) array.get(i);
    System.out.println("Lat is:  " + firstObject.getDouble("gpsLat"));
    System.out.println("Long is: " + firstObject.getDouble("gpsLong"));
}