@Override
public void onMapReady(GoogleMap googleMap) {
    MapsInitializer.initialize(getContext());

    mGoogleMap = googleMap;

    // move them here:
    GeoJsonLayer layer = new GeoJsonLayer(mGoogleMap, R.raw.picnicsites,
        getApplicationContext());

    layer.addLayerToMap();

    googleMap.setMapType( GoogleMap.MAP_TYPE_SATELLITE );

    googleMap.addMarker( new MarkerOptions()
            .position(new LatLng( 35.126411, 33.429859 ) )
            .title( "Cyprus" )
            .snippet( "Center of island" )
            .icon( BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

    CameraPosition Liberty = CameraPosition.builder()
            .target(new LatLng( 36.126411, 33.429859 ))
            .zoom( 8f )
            .bearing( 0 )
            .tilt( 0 )
            .build();

    googleMap.moveCamera( CameraUpdateFactory.newCameraPosition( Liberty ) );

}