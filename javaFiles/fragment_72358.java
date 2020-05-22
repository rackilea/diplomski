// get all nearby users:
private void getNearbyUsers() {
    Log.d("MainActivity", "getNearbyUsers() triggered!");

    GeoLocation currentLocationGeoHash = new GeoLocation(mCurrentLocation.getLatitude(), mCurrentLocation.getLongitude());
    if(geoQueryNearByUser == null){
        geoQueryNearByUser = geoFire.queryAtLocation(currentLocationGeoHash, mCurrentUserProximityRadius);

        geoQueryNearByUser.addGeoQueryEventListener(geoQueryEventListener);
    }
    else {
        geoQueryNearByUser.setCenter(currentLocationGeoHash);
    }

}
// end of getNearbyUsers()