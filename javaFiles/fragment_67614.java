@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initLocationFetching(MainActivity.this);

    mapFragment = new MapFragment(MainActivity.this, this);
    manager = getSupportFragmentManager();
}
 @Override
    public void locationFetched(Location mLocal, Location oldLocation, String time, String locationProvider) {
    super.locationFetched(mLocal, oldLocation, time, locationProvider);
 //After initLocationFetching.
 Bundle bundle = new Bundle();
 bundle.putDouble("Lat",mLocal.getLatitude());
 bundle.putDouble("Long"mLocal.getLongitude());
 mapFragment.setArguments(bundle);
 manager.beginTransaction().replace(R.id.mainLayout, mapFragment).commit();
}



//In MapFragment
class MapFragment extends Fragment implements OnMapReadyCallback,
        GoogleApiClient.OnConnectionFailedListener {
double lati=0.0;
double longi=0.0;

@Override
public void onCreate(Bundle bundle){
lati=getArguments().getDouble("Lat");
longi=getArguments().getDouble("Long");
}

@Override
public void onMapReady(GoogleMap googleMap) {
    mMap = googleMap;

    LatLng origin = new LatLng(lati,longi);

    mMap.addMarker(new MarkerOptions()
            .position(new LatLng(lati,longi))
            .anchor(0.5f, 0.5f)
            .title("title")
            .snippet("snippet")
            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));

    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(value1, value2), 9.0f));

}