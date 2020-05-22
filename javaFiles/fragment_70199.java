public class MainActivity extends Activity {

    private static LatLng goodLatLng = new LatLng(37, -120);
    private GoogleMap googleMap;
    private EditText et_address, et_finalAddress;
    LatLng addressPos, finalAddressPos;
    Marker addressMarker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_address = (EditText) findViewById(R.id.addressEditText);
        et_finalAddress = (EditText) findViewById(R.id.finalAddressEditText);


        // Initial Map
        try {

            if (googleMap == null) {
                googleMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        // Put a dot on my current location
        googleMap.setMyLocationEnabled(true);
        googleMap.setIndoorEnabled(true);
        googleMap.setTrafficEnabled(true);
        // 3D building
        googleMap.setBuildingsEnabled(true);
        // Get zoom button
        googleMap.getUiSettings().setZoomControlsEnabled(true);

        Marker marker = googleMap.addMarker(new MarkerOptions()
                .position(goodLatLng)
                .title("Hello"));
    }