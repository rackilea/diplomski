private LatLng getLatLng(JSONObject coordinateJSON) throws JSONException {
    double lat = coordinateJSON.getDouble("lat");
    double lon = coordinateJSON.getDouble("lng");

    return new LatLng(lat, lon);
}