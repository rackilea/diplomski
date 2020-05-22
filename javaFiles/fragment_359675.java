JSONObject data = [insert something following your structure above];
JSONArray bannerConfigurations = data.get("BannerConfigurations");
for (int i=0; i<bannerConfigurations.length(); i++) {
    JSONObject device = bannerConfigurations.getJSONObject(i);
    String deviceType = device.getString("deviceType");
    int id = device.getInt("id");
    // do stuff!
}