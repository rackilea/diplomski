// Somewhere above:
private Marker mMyLocationMarker;

// Add marker with options
mMyLocationMarker = mGoogleMap.addMarker(options);

// And to remove:
mMyLocationMarker.remove();