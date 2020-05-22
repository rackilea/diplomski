public class NeueRouteAufzeichnen extends FragmentActivity implements OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    private Location mLastLocation;
    private Location previousLocation;
    private long distanceTraveled;

    private boolean tracking = false;
    private long startTime;
    private PowerManager.WakeLock wakeLock;
    private boolean gpsFix;

    private static final double MILLISECONDS_PER_HOUR = 100 * 60 * 60;
    private static final double MILES_PER_KILOMETER = 0.621371192;
    private static final int MAP_ZOOM = 18;

    private List<Location> locations;

    private GoogleApiClient mGoogleApiClient;

    GoogleMap map;
    LatLng myPosition;
    boolean mapIsReady = false;

    LocationRequest mLocationRequest;

    com.google.android.gms.location.LocationListener mlocationListener = new com.google.android.gms.location.LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            updateLocation(location);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (mGoogleApiClient == null) {
            mGoogleApiClient = new GoogleApiClient.Builder(this)
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .addApi(LocationServices.API)
                    .addApi(AppIndex.API).build();
        }
        setContentView(R.layout.activity_neue_route_aufzeichnen);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        locations = new ArrayList<Location>();
    }

    protected void onStart() {
        mGoogleApiClient.connect();
        super.onStart();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "NeueRouteAufzeichnen Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.noureddine_ouertani.www.wocelli50/http/host/path")
        );
        AppIndex.AppIndexApi.start(mGoogleApiClient, viewAction);
    }

    protected void onStop() {
        mGoogleApiClient.disconnect();
        super.onStop();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "NeueRouteAufzeichnen Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.noureddine_ouertani.www.wocelli50/http/host/path")
        );
        AppIndex.AppIndexApi.end(mGoogleApiClient, viewAction);
    }

    @Override
    public void onConnected(Bundle connectionHint) {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(getApplicationContext(), "Permissions missing for mGoogleApiClient.", Toast.LENGTH_SHORT).show();
        }
        Toast.makeText(getApplicationContext(), "mGoogleApiClient is connected.", Toast.LENGTH_SHORT).show();
        mLastLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
        if (mLastLocation != null) {
            Toast.makeText(getApplicationContext(), "YES! mLastLocation!=null", Toast.LENGTH_SHORT).show();
        }

        mLocationRequest = LocationRequest.create();
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        mLocationRequest.setInterval(1000); // 1 SECOND
        mLocationRequest.setFastestInterval(1000); // 1 SECOND
        LocationServices.FusedLocationApi.requestLocationUpdates(
                mGoogleApiClient, mLocationRequest, mlocationListener);
    }

    @Override
    public void onConnectionSuspended(int i) {
        Toast.makeText(getApplicationContext(), "Connection of mGoogleApiClient is suspended.", Toast.LENGTH_SHORT).show();
    }

    public void addPoint(Location location) {
        locations.add(location);
        Toast.makeText(getApplicationContext(), "addPoint has been called.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onMapReady(GoogleMap map) {
        this.map = map;

        distanceTraveled = 0;

        Criteria criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_FINE);
        criteria.setBearingRequired(true);
        criteria.setCostAllowed(true);
        criteria.setPowerRequirement(Criteria.POWER_LOW);
        criteria.setAltitudeRequired(false);

        Toast.makeText(getApplicationContext(), "onMapReady is called.", Toast.LENGTH_SHORT).show();

        PowerManager powerManager = (PowerManager) getSystemService(Context.POWER_SERVICE);
        wakeLock = powerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "NO Sleep");
        wakeLock.acquire();
        if (!mGoogleApiClient.isConnected()) {
            mGoogleApiClient.connect();
        }

        tracking = true;
        startTime = System.currentTimeMillis();
        //Toast.makeText(getApplicationContext(), " mGoogleApiClient.connect()call from onMapReady!", Toast.LENGTH_SHORT).show();
        //LatLng sydney = new LatLng(-34, 151);
        //map.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        //map.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        mapIsReady = true;

    }

    protected void updateLocation(Location location) {
        Toast.makeText(getApplicationContext(), "updateLocation method called.", Toast.LENGTH_SHORT).show();
        if (location != null && gpsFix == true) {
            addPoint(location);

            if (previousLocation != null)
                distanceTraveled += location.distanceTo(previousLocation);
        }

        if (map != null && mapIsReady == true) {
            Toast.makeText(getApplicationContext(), " got last location ... mLastlocation displayed!", Toast.LENGTH_SHORT).show();
            LatLng newPosition = new LatLng(location.getLatitude(), location.getLongitude());
            map.addMarker(new MarkerOptions().position(newPosition).title("newPosition"));
            map.moveCamera(CameraUpdateFactory.newLatLng(newPosition));
            locations.add(mLastLocation);
        }

        previousLocation = location;
    }

    public void draw() {
        Toast.makeText(getApplicationContext(), "Draw method called.", Toast.LENGTH_SHORT).show();
        if (map == null) {
            return;
        }

        PolylineOptions options = new PolylineOptions();

        options.color(Color.parseColor("#CC0000FF"));
        options.width(5);
        options.visible(true);

        for (Location locRecorded : locations) {
            options.add(new LatLng(locRecorded.getLatitude(),
                    locRecorded.getLongitude()));
            Toast.makeText(getApplicationContext(), "draw method got new location!", Toast.LENGTH_SHORT).show();


        }

        map.addPolyline(options);

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Toast.makeText(getApplicationContext(), "Connection of mGoogleApiClient failed.", Toast.LENGTH_SHORT).show();
    }
}