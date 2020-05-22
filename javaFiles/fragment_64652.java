@Override
public void onMapReady(GoogleMap googleMap) {
    mMap = googleMap;
    RelativeLayout mapLayout = (RelativeLayout) findViewById(R.id.mapRelativeLayout);
    mapLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
        @Override
        public void onGlobalLayout() {

            LatLng driverLocation = new LatLng(intent.getDoubleExtra("driverLatitude", 0), intent.getDoubleExtra("driverLongitude", 0));
            LatLng requestLocation = new LatLng(intent.getDoubleExtra("requestLatitude",0), intent.getDoubleExtra("requestLongitude",0));

            markers.add(mMap.addMarker(new MarkerOptions().position(driverLocation).title("your location")));
            markers.add(mMap.addMarker(new MarkerOptions().position(requestLocation).title("driverLocation")));

            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            for (Marker marker : markers) {
                builder.include(marker.getPosition());
            }
            LatLngBounds bounds = builder.build();

            int padding = 60; // offset from edges of the map in pixels
            CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds, padding);


            mMap.animateCamera(cu);
        }
    });

}