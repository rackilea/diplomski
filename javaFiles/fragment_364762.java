GPSTracker gps;
double latitude;
double longitude;

gps = new GPSTracker(your context);
gps.getLocation();
// Check if GPS enabled
if(gps.canGetLocation()) {
    latitude = gps.getLatitude();
    longitude = gps.getLongitude();
}