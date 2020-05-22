try {
    String jsonString = "{ \"bounds\" : { \"northeast\" : { \"lat\" : 37.842911, \"lng\" : -85.682537 }, \"southwest\" : { \"lat\" : 37.559684, \"lng\" : -86.07509399999999 } }, \"location\" : { \"lat\" : 37.7030051, \"lng\" : -85.8647201 }, \"location_type\" : \"APPROXIMATE\", \"viewport\" : { \"northeast\" : { \"lat\" : 37.842911, \"lng\" : -85.682537 }, \"southwest\" : { \"lat\" : 37.559684, \"lng\" : -86.07509399999999 } } }";
    JSONObject object = new JSONObject(jsonString);

    JSONObject boundsJSON = object.getJSONObject("bounds");
    LatLng northeast = getLatLng(boundsJSON.getJSONObject("northeast"));
    LatLng southwest = getLatLng(boundsJSON.getJSONObject("southwest"));
    LatLng northwest = new LatLng(northeast.latitude, southwest.longitude);
    LatLng southeast = new LatLng(southwest.latitude, northeast.longitude);

    List<LatLng> path = new ArrayList<>();
    path.add(northwest);
    path.add(northeast);
    path.add(southeast);
    path.add(southwest);
    path.add(northwest);
    double perimeter = SphericalUtil.computeLength(path);
} catch (JSONException e) {
    // TODO: Handle the exception
    String a = "";
}