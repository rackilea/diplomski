private BitmapDescriptor markerDescriptor;
private int accuracyStrokeColor = Color.argb(255, 130, 182, 228);
private int accuracyFillColor = Color.argb(100, 130, 182, 228);

private Marker positionMarker;
private Circle accuracyCircle;

@Override
protected void onCreate(Bundle savedInstanceState) {
    // ...

    markerDescriptor = BitmapDescriptorFactory.fromResource(R.drawable.yourmarkericon);
}

@Override
public void onLocationChanged(Location location) {
    double latitude = location.getLatitude();
    double longitude = location.getLongitude();
    float accuracy = location.getAccuracy();

    if (positionMarker != null) {
        positionMarker.remove();
    }
    final MarkerOptions positionMarkerOptions = new MarkerOptions()
            .position(new LatLng(latitude, longitude))
            .icon(markerDescriptor)
            .anchor(0.5f, 0.5f);
    positionMarker = mMap.addMarker(positionMarkerOptions);

    if (accuracyCircle != null) {
        accuracyCircle.remove();
    }
    final CircleOptions accuracyCircleOptions = new CircleOptions()
            .center(new LatLng(latitude, longitude))
            .radius(accuracy)
            .fillColor(accuracyFillColor)
            .strokeColor(accuracyStrokeColor)
            .strokeWidth(2.0f);
    accuracyCircle = mMap.addCircle(accuracyCircleOptions);
}