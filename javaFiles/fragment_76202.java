private GoogleMap mGoogleMap;
// Create a LatLngBounds that includes Australia.
private LatLngBounds YOUR_CITY_OR_COUNTRY = new LatLngBounds(
new LatLng(-23, -66), new LatLng(-43, -68));

// Set the camera to the greatest possible zoom level that includes the
// bounds
mGoogleMap.setLatLngBoundsForCameraTarget(YOUR_CITY_OR_COUNTRY);