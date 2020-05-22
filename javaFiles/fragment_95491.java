public void onMapReady(GoogleMap googleMap){

    mMap = googleMap;

    addPolylineToMap();
}

private void addPolylineToMap(){
    double[] receivedDataArray;
    double latitude;
    double longitude;
    // Clear the list first
    mCoordList.clear();

    for (int i = 0; i < coordinatesArray.size() - 1; i++) {
        receivedDataArray = coordinatesArray.get(i);

        latitude = receivedDataArray[0];
        longitude = receivedDataArray[1];

        mCoordList.add(new LatLng(latitude,longitude));
        Log.e(TAG, "List size = " + mCoordList.size());
    }

    //You can also call ...
    //mMap.clear();
    //...in order to remove all markings on the map

    if(mPolyline != null){
        mPolyline.remove();
    }

    options = new PolylineOptions().addAll(coordList).width(10).color(Color.BLUE).geodesic(true);
    mPolyline = mMap.addPolyline(options);
}