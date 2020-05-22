final JSONArray jsonArray = new JSONArray(source);
final int length = jsonArray.length();

for (int i = 0; i < length; i++) {
    final JSONObject jsonObject = jsonArray.getJSONObject(i);
    final JSONObject forecastOrig =
            jsonObject.getJSONObject("875488")
                      .getJSONObject("forecast_orig");

    final double lon = forecastOrig.getDouble("lon");
    final double lat = forecastOrig.getDouble("lat");

    System.out.println(lon);
    System.out.println(lat);
}