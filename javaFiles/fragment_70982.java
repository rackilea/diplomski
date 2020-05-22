private GoogleMap mMap;
// Create a LatLngBounds that includes the city of Adelaide in Australia.
private LatLngBounds ADELAIDE = new LatLngBounds(
  new LatLng(-35.0, 138.58), new LatLng(-34.9, 138.61));
// Constrain the camera target to the Adelaide bounds.
mMap.setLatLngBoundsForCameraTarget(ADELAIDE);