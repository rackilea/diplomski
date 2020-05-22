private static GeoApiContext context = new GeoApiContext.Builder()
           .apiKey(API_KEY)
           .queryRateLimit(50)
           .build();
private static String geocode(String address) throws InterruptedException, ApiException, IOException, JSONException {
    GeocodingResult[] results =  GeocodingApi.geocode(context,
            address).await();
    String latLong = "";
    if(results != null && results.length > 0) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        latLong = gson.toJson(results[0].geometry);
        String latitude = "";
        String longitude = "";
        JSONObject jsonObject = new JSONObject(latLong);
        JSONObject location = jsonObject.getJSONObject("location");
        latitude = location.getString("lat");
        longitude = location.getString("lng");

        latLong = latitude + "," + longitude;
    }
    return  latLong;
}