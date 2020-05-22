PolylineOptions polylineOptions = new PolylineOptions();
polylineOptions.color(Color.BLUE);
// add coordinates to polyline
for (LatLng markerCoordinate : markerCoordinates) {
    polylineOptions.add(markerCoordinate);
}

// draw
googleMap.addPolyline(polylineOptions);