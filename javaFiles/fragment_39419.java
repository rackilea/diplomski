protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    map = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();

    // Add this line
    map.setMyLocationEnabled(true);

    locManager = (LocationManager)getSystemService(LOCATION_SERVICE);
    providersList = locManager.getAllProviders();
    provider =locManager.getProvider(providersList.get(0));
    precision = provider.getAccuracy();
    req = new Criteria();
    req.setAccuracy(Criteria.ACCURACY_FINE);        
    inside = false;

    //map.getUiSettings().setMyLocationButtonEnabled(true);

    buildPolygon();
    drawPolygon();
    startLocalization();
}