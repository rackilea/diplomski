public class MainActivity extends Activity implements LocationListener{
protected LocationManager locationManager;
protected LocationListener locationListener;
protected Context context;
TextView txtLat;
String lat;
String provider;
protected String latitude,longitude; 
protected boolean gps_enabled,network_enabled;

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);
txtLat = (TextView) findViewById(R.id.textview1);

locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
}
@Override
public void onLocationChanged(Location location) {
txtLat = (TextView) findViewById(R.id.textview1);
double lat = location.getLatitude(); 
double longi = location.getLongitude();
txtLat.setText("Latitude:" + location.getLatitude() + ", Longitude:" +    location.getLongitude());
}

@Override
public void onProviderDisabled(String provider) {
Log.d("Latitude","disable");
}

@Override
public void onProviderEnabled(String provider) {
Log.d("Latitude","enable");
}

@Override
public void onStatusChanged(String provider, int status, Bundle extras) {
Log.d("Latitude","status");
}
}