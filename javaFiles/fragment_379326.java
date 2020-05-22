class MyActivity extends Activity {
    Circle mapCircle = null;

    public someMethod() {
        // Inside location callback
        locationCallback = new LocationCallback() {
            @Override
            public void onLocationResult(LocationResult locationResult) {
                super.onLocationResult(locationResult);
                if (locationResult == null) {
                    return;
                }

                mLastKnownLocation = locationResult.getLastLocation();
                checkLocation = mLastKnownLocation;

                LatLng lastKnownLatLng = new LatLng(mLastKnownLocation.getLatitude(), mLastKnownLocation.getLongitude());

                if (mapCircle != null) {
                    mapCircle.remove();
                }
                mapCircle = mMap.addCircle(new CircleOptions()
                        .center(new LatLng(mLastKnownLocation.getLatitude(),mLastKnownLocation.getLongitude()))
                        .radius(20)
                        .strokeColor(Color.argb(200,0,64,122))
                        .strokeWidth(5)
                        .fillColor(Color.argb(100,82,189,236)));
                mapCircle.setCenter(new LatLng(mLastKnownLocation.getLatitude(),mLastKnownLocation.getLongitude()));
            }
        }
    }
}