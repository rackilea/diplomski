((SupportMapFragment) getSupportFragmentManager()
            .findFragmentById(R.id.map)).getMapAsync(new OnMapReadyCallback() {

  @Override
  public void onMapReady(GoogleMap googleMap) {

       googleMap.addMarker(new MarkerOptions()
           .position(new LatLng(37.7750, 122.4183))
           .title("San Francisco")
           .snippet("Population: 776733"));
   }

}