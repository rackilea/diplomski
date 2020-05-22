@Override
public void onLocationChanged(Location location) {

    mLastLocation = location;
    if (mCurrLocationMarker != null) {
        mCurrLocationMarker.remove();
    }

    /** Setting current location marker */
    start = new LatLng(location.getLatitude(),location.getLongitude());
    MarkerOptions markerOptions = new MarkerOptions();
    markerOptions.position(start);
    markerOptions.title("Current Location");
    markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
    mCurrLocationMarker = mMap.addMarker(markerOptions);

    //If there is a previous route drawn:
    if (mClickedPoints.size() >= 2) {
        //remove the old origin:
        mClickedPoints.remove(0);

        //add the new one at the 0th position:
        mClickedPoints.add(0, start);

        //set orig and dest for directions:
        orig = mClickedPoints.get(0);
        dest = mClickedPoints.get(1);

        //get updated directions:
        request_directions_and_get_response();
    }

}