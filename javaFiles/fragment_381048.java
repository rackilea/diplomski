private GoogleMap mMap;

    mMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();

    mMap.addMarker(new MarkerOptions()
        .position(new LatLng(0, 0))
        .title("Hello world")
    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));