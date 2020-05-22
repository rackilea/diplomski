public class UseGps extends Activity
{
    Button gps_button;
    TextView gps_text;
    LocationManager mlocManager;

    /** Called when the activity is first created. */

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        gps_button = (Button) findViewById(R.id.GPSButton);
        gps_text = (TextView) findViewById(R.id.GPSText);

        gps_button.setOnClickListener(new OnClickListener() {
            public void onClick(View viewParam) {
                gps_text.append("\n\nSearching for current location. Please hold...");
                gps_button.setEnabled(false);
                mlocManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
                LocationListener mlocListener = new MyLocationListener();
                mlocManager.requestLocationUpdates( LocationManager.GPS_PROVIDER, 0, 0, mlocListener);
            }
        });
    }

    /* Class My Location Listener */
    public class MyLocationListener implements LocationListener
    {
        @Override
        public void onLocationChanged(Location loc)
        {
            double lon = loc.getLatitude();
            double lat = loc.getLongitude();
            gps_text.append("\nLongitude: "+lon+" - Latitude: "+lat);
            UseGps.this.mlocManager.removeUpdates(this);
            gps_button.setEnabled(true);
        }

        @Override
        public void onProviderDisabled(String provider) {
            // TODO Auto-generated method stub
        }

        @Override
        public void onProviderEnabled(String provider) {
            // TODO Auto-generated method stub
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
            // TODO Auto-generated method stub
        }
    }
}