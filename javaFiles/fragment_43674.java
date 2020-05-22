@Override
public void onLocationChanged(Location location) {
    //Hey, a non null location! Sweet!

    //remove location callback:
    locationManager.removeUpdates(this);

    //open the map:
    latitude = location.getLatitude();
    longitude = location.getLongitude();
    Toast.makeText(MainActivity.this, "latitude:" + latitude + " longitude:" + longitude, Toast.LENGTH_SHORT).show();
    searchNearestPlace(voice2text);
}