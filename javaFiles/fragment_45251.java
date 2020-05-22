@Override
public void onLocationChanged(Location lokacija1) {
    location = (TextView) findViewById(R.id.tekst1);

    double lat = lokacija1.getLatitude();
    double lng = lokacija1.getLongitude();

    if (lat > 52 && lat < 54 && lon > 46.0 && lon < 48.0) {
        location.setText("Region 1");
    } else if (lat > 54 && lat < 56 && lon > 48.0 && lon < 50.0) {
        location.setText("Region 2");
    } else {
        location.setText("Unrecognized region");
    }

    Log.d("TAG", String.format("lat:%.4f lon:%.4f", lat, lng));
}