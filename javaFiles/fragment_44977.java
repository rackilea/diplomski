JSONObject properties = currentEarthquake.getJSONObject("properties");

long time = properties.getLong("time");
String mag = properties.getString("mag");
String place = properties.getString("place");
String date = properties.getString("time");

earthquakes.add(new Earthquakes(mag,place,time));