@Override
public void onLocationChanged(Location location) {

    latitude = String.valueOf(location.getLatitude());
    longitude = String.valueOf(location.getLongitude());

    new MyAsyncTask().execute();                
}