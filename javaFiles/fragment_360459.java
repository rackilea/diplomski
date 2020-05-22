private static final LatLng MELBOURNE = new LatLng(-37.813, 144.962);
private Marker melbourne = mMap.addMarker(new MarkerOptions()
.position(MELBOURNE)
.title("Melbourne")
.snippet("Population: 4,137,400")
.icon(BitmapDescriptorFactory.fromResource(R.drawable.arrow)));