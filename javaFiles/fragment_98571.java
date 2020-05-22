public class MainActivity extends AppCompatActivity {
        public LocationManager lm;
        TextView textView;
     @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 1, new MyLocationListener());
            textView = (TextView)findViewById(R.id.textView);
            Button gpsBtn = (Button)findViewById(R.id.getLocation);
            gpsBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showCurrentLocation();
                }
            });

        public void showCurrentLocation() {
            // TODO Auto-generated method stub
            Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            try{
                textView.setText(String.valueOf(location.getLatitude()));
            }catch(Exception e){
              // exception occurs......
            }
        }
        class MyLocationListener implements LocationListener {
            @Override
            public void onLocationChanged(Location location) {
                // TODO Auto-generated method stub
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