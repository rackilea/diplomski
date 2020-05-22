GPSTracker gps = new GPSTracker(context);
double latitude = gps.getLatitude();
double longitude = gps.getLongitude();

//    Then pass this lattitude and longitude as shown below.
Intent intent = new Intent (this, yourSecondActivity.class)
intent.putExtra("latitude ",latitude );
intent.putExtra("longitude ",longitude );
startActivity(intent);