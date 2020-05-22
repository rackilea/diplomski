public class TestActivityMAp extends FragmentActivity implements
    OnMapReadyCallback,
    GoogleMap.OnPolylineClickListener,
    GoogleMap.OnPolygonClickListener  {

private GoogleMap mMap;


private static final int COLOR_BLACK_ARGB = 0xff000000;
private static final int POLYLINE_STROKE_WIDTH_PX = 12;







private static final int COLOR_WHITE_ARGB = 0xffffffff;
private static final int COLOR_GREEN_ARGB = 0xff388E3C;
private static final int COLOR_PURPLE_ARGB = 0xff81C784;
private static final int COLOR_ORANGE_ARGB = 0xffF57F17;
private static final int COLOR_BLUE_ARGB = 0xffF9A825;

private static final int POLYGON_STROKE_WIDTH_PX = 8;
private static final int PATTERN_DASH_LENGTH_PX = 20;
private static final int PATTERN_GAP_LENGTH_PX = 20;
private static final PatternItem DOT = new Dot();
private static final PatternItem DASH = new Dash(PATTERN_DASH_LENGTH_PX);
private static final PatternItem GAP = new Gap(PATTERN_GAP_LENGTH_PX);
//
// Create a stroke pattern of a gap followed by a dot.
private static final List<PatternItem> PATTERN_POLYLINE_DOTTED = 
Arrays.asList(GAP, DOT);


// Create a stroke pattern of a gap followed by a dash.
private static final List<PatternItem> PATTERN_POLYGON_ALPHA = 
Arrays.asList(GAP, DASH);

// Create a stroke pattern of a dot followed by a gap, a dash, and another 
gap.
private static final List<PatternItem> PATTERN_POLYGON_BETA =
        Arrays.asList(DOT, GAP, DASH, GAP);

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_test_map);
    // Obtain the SupportMapFragment and get notified when the map is ready to 
    be used.
    SupportMapFragment mapFragment = (SupportMapFragment) 
getSupportFragmentManager()
            .findFragmentById(R.id.map);
    mapFragment.getMapAsync(this);
}


/**
 * Manipulates the map once available.
 * This callback is triggered when the map is ready to be used.
 * This is where we can add markers or lines, add listeners or move the 
camera. In this case,
 * we just add a marker near Sydney, Australia.
 * If Google Play services is not installed on the device, the user will be 
prompted to install
 * it inside the SupportMapFragment. This method will only be triggered once 
the user has
 * installed Google Play services and returned to the app.
 */
@Override
public void onMapReady(GoogleMap googleMap) {
    mMap = googleMap;
//
// Add a marker in Sydney and move the camera
//        LatLng sydney = new LatLng(-34, 151);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in 
Sydney"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));



    Polyline polyline2 = googleMap.addPolyline(new PolylineOptions()
            .clickable(true)
            .add(
                    new LatLng(-27.457, 153.040),
                    new LatLng(-33.852, 151.211),
                    new LatLng(-37.813, 144.962),
                    new LatLng(-34.928, 138.599),
                    new LatLng(-25.928, 140.599)));
// Store a data object with the polyline, used here to indicate an arbitrary 
type.
    polyline2.setTag("A");

    Polygon polygon1 = googleMap.addPolygon(new PolygonOptions()
            .clickable(true)
            .add(
                    new LatLng(-27.457, 153.040),
                    new LatLng(-33.852, 151.211),
                    new LatLng(-37.813, 144.962),
                    new LatLng(-34.928, 138.599),
                    new LatLng(-25.928, 140.599)));
// Store a data object with the polygon, used here to indicate an arbitrary 
type.
    polygon1.setTag("alpha");

    stylePolygon(polygon1);

    // Position the map's camera near Alice Springs in the center of 
Australia,
    // and set the zoom factor so most of Australia shows on the screen.
    googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-23.684, 
133.903), 4));

    // Set listeners for click events.
    googleMap.setOnPolylineClickListener(this);
    googleMap.setOnPolygonClickListener(this);
}


private void stylePolygon(Polygon polygon) {
    String type = "";
    // Get the data object stored with the polygon.
    if (polygon.getTag() != null) {
        type = polygon.getTag().toString();
    }

    List<PatternItem> pattern = null;
    int strokeColor = COLOR_BLACK_ARGB;
    int fillColor = COLOR_WHITE_ARGB;

    switch (type) {
        // If no type is given, allow the API to use the default.
        case "alpha":
            // Apply a stroke pattern to render a dashed line, and define 
colors.
            pattern = PATTERN_POLYGON_ALPHA;
            strokeColor = COLOR_GREEN_ARGB;
            fillColor = COLOR_PURPLE_ARGB;
            break;
        case "beta":
            // Apply a stroke pattern to render a line of dots and dashes, and 
define colors.
            pattern = PATTERN_POLYGON_BETA;
            strokeColor = COLOR_ORANGE_ARGB;
            fillColor = COLOR_BLUE_ARGB;
            break;
    }

    polygon.setStrokePattern(pattern);
    polygon.setStrokeWidth(POLYGON_STROKE_WIDTH_PX);
    polygon.setStrokeColor(strokeColor);
    polygon.setFillColor(fillColor);
}


private void stylePolyline(Polyline polyline) {
    String type = "";
    // Get the data object stored with the polyline.
    if (polyline.getTag() != null) {
        type = polyline.getTag().toString();
    }

    switch (type) {
        // If no type is given, allow the API to use the default.
        case "A":
            // Use a custom bitmap as the cap at the start of the line.
            polyline.setStartCap(
                    new CustomCap(

BitmapDescriptorFactory.fromResource(R.drawable.ic_arrow_forward_white_24dp), 
10));
            break;
        case "B":
            // Use a round cap at the start of the line.
            polyline.setStartCap(new RoundCap());
            break;
    }

    polyline.setEndCap(new RoundCap());
    polyline.setWidth(POLYLINE_STROKE_WIDTH_PX);
    polyline.setColor(COLOR_BLACK_ARGB);
    polyline.setJointType(JointType.ROUND);
}




@Override
public void onPolygonClick(Polygon polygon) {

}

@Override
public void onPolylineClick(Polyline polyline) {
    // Flip from solid stroke to dotted stroke pattern.
    if ((polyline.getPattern() == null) || 
(!polyline.getPattern().contains(DOT))) {
        polyline.setPattern(PATTERN_POLYLINE_DOTTED);
    } else {
        // The default pattern is a solid stroke.
        polyline.setPattern(null);
    }

    Toast.makeText(this, "Route type " + polyline.getTag().toString(),
            Toast.LENGTH_SHORT).show();
}
}