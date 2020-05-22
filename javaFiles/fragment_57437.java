@Override
public void onMapReady(GoogleMap googleMap) {
    mMap = googleMap;

    //Maybe move this to an else on the if below? I'm not sure exactly what this does
    gotoLocation(51.508182, -0.140315, DEFAULT_ZOOM);

    //Update to the saved position.
    MapStateManager mgr = new MapStateManager(this);
    CameraPosition position = mgr.getSavedCameraPosition();
    if(position != null){
        CameraUpdate update = CameraUpdateFactory.newCameraPosition(position);
        mMap.moveCamera(update);
    }
}

@Override
protected void onResume(){
    super.onResume();

    //Get the map asynchronously again.

    // Obtain the SupportMapFragment and get notified when the map is ready to be used.
    SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
    mapFragment.getMapAsync(this);
}