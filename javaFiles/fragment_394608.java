public class MyActivity extends MapActivity implements LocationListener, OnClickListener {

    private MapView mapView;
    private MyItemizedOverlay itemizedOverlay;
    Button route;
    boolean shadow;
    private LocationManager locManager;
    ArrayList<GeoPoint> points = new ArrayList<GeoPoint>();

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        route = (Button) findViewById(R.id.cmd_submit);
        route.setOnClickListener(this);



        //fetch the map view from the layout
        mapView = (MapView) findViewById(R.id.myMapView);

        //make available zoom controls
        mapView.setBuiltInZoomControls(true);



        //latitude and longitude of Rome
        double lat = 41.889882;
        double lon = 12.479267;

        //create geo point
        GeoPoint point = new GeoPoint((int) (lat * 1E6), (int) (lon * 1E6));

        //get the MapController object
        MapController controller = mapView.getController();

        //animate to the desired point
        controller.animateTo(point);

        //set the map zoom to 13
        // zoom 1 is top world view
        controller.setZoom(13);

        //invalidate the map in order to show changes
        mapView.invalidate();



        // Use the location manager through GPS
        locManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0,
                0, this);

        //get the current location (last known location) from the location manager
        Location location = locManager
                .getLastKnownLocation(LocationManager.GPS_PROVIDER);


        //if location found display as a toast the current latitude and longitude
        if (location != null) {

            Toast.makeText(
                    this,
                    "Current location:\nLatitude: " + location.getLatitude()
                    + "\n" + "Longitude: " + location.getLongitude(),
                    Toast.LENGTH_LONG).show();

            point = new GeoPoint((int) (location.getLatitude() * 1E6), (int) (location.getLongitude()
                    * 1E6));

            controller.animateTo(point);


        } else {

            Toast.makeText(this, "Cannot fetch current location!",
                    Toast.LENGTH_LONG).show();
        }

        //when the current location is found – stop listening for updates (preserves battery)
        locManager.removeUpdates(this);

        // fetch the drawable - the pin that will be displayed on the map
        Drawable drawable = this.getResources().getDrawable(R.drawable.marker);

        // create and add an OverlayItem to the MyItemizedOverlay list
        OverlayItem overlayItem = new OverlayItem(point, "", "");

        itemizedOverlay = new MyItemizedOverlay(drawable, this);

        itemizedOverlay.setGestureDetector(new GestureDetector(new MyGestureDetector()));

        itemizedOverlay.addOverlay(overlayItem);


        // add the overlays to the map
        mapView.getOverlays().add(itemizedOverlay);
        mapView.invalidate();

        //when the current location is found – stop listening for updates (preserves battery)
        locManager.removeUpdates(this);
    }

    @Override
    protected boolean isRouteDisplayed() {
        return false;

    }

    /* When the activity starts up, request updates */
    @Override
    protected void onResume() {
        super.onResume();
        locManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0,
                0, this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        locManager.removeUpdates(this); //activity pauses => stop listening for updates
    }
}