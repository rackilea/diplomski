@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);


    MapView map = (MapView) findViewById(R.id.map);
    map.setTileSource(TileSourceFactory.MAPNIK);
    map.setBuiltInZoomControls(true);
    map.setMultiTouchControls(true);


    IMapController mapController = map.getController();
    mapController.setZoom(9);
    GeoPoint startPoint = new GeoPoint(-36.66372, 174.69231);
    mapController.setCenter(startPoint);

    Polygon polyline = new Polygon(this);
    List<GeoPoint> points = new LinkedList<>();

    // I filled the data manually, but it can be done more clever, of course.
    GRC(points, new GeoPoint(-36.76736, 174.83433));
    CWA(points, new GeoPoint(-36.93842, 174.55269),
                new GeoPoint(-36.87200, 174.48986),
                new GeoPoint(-36.80550, 174.42714),
                0.08333);
    CCA(points, new GeoPoint(-36.68503, 174.62581),
                new GeoPoint(-36.66514, 174.64464),
                new GeoPoint(-36.68342, 174.66586),
                0.02500);
    CCA(points, new GeoPoint(-36.66372, 174.69231),
                new GeoPoint(-36.64542, 174.67103),
                new GeoPoint(-36.65486, 174.69992),
                0.02500);
    GRC(points, new GeoPoint(-36.66072, 174.74381));
    CWA(points, new GeoPoint(-36.61911, 174.79094),
                new GeoPoint(-36.70106, 174.77139),
                new GeoPoint(-36.76736, 174.83433), //close shape going to the start point
                0.08333);

    polyline.setPoints(points);
    polyline.setFillColor(0xA0FF00FF);
    polyline.setStrokeColor(Color.BLACK);
    polyline.setStrokeWidth(2f);
    map.getOverlays().add(polyline);
    map.invalidate();
}

private void CCA(List<GeoPoint> points, GeoPoint startPoint, GeoPoint centerPoint, GeoPoint endPoint, double radius) {
    points.add(startPoint);

    GeodesicData f = Geodesic.WGS84.Inverse(centerPoint.getLatitude(), centerPoint.getLongitude(), startPoint.getLatitude(), startPoint.getLongitude());
    GeodesicData t = Geodesic.WGS84.Inverse(centerPoint.getLatitude(), centerPoint.getLongitude(), endPoint.getLatitude(), endPoint.getLongitude());

    double ffaz = f.azi1;
    double tfaz = t.azi1;

    final int decrement = 1;
    while (Math.abs((int)ffaz) != Math.abs((int)tfaz)) {
        GeodesicData llb = Geodesic.WGS84.Direct(centerPoint.getLatitude(), centerPoint.getLongitude(), ffaz,  f.s12);
        points.add(new GeoPoint(llb.lat2, llb.lon2));
        ffaz -= decrement;
        if (ffaz <0) {
            ffaz += 360;
        }
    }

    points.add(endPoint);
}

private void CWA(List<GeoPoint> points, GeoPoint startPoint, GeoPoint centerPoint, GeoPoint endPoint, double radius) {
    points.add(startPoint);

    GeodesicData f = Geodesic.WGS84.Inverse(centerPoint.getLatitude(), centerPoint.getLongitude(), startPoint.getLatitude(), startPoint.getLongitude());
    GeodesicData t = Geodesic.WGS84.Inverse(centerPoint.getLatitude(), centerPoint.getLongitude(), endPoint.getLatitude(), endPoint.getLongitude());

    double ffaz = f.azi1;
    double tfaz = t.azi1 > 0 ? t.azi1 : 360 + t.azi1;

    final int increment = 1;
    while (Math.abs((int)ffaz) != Math.abs((int)tfaz)) {
        GeodesicData llb = Geodesic.WGS84.Direct(centerPoint.getLatitude(), centerPoint.getLongitude(), ffaz, f.s12);
        points.add(new GeoPoint(llb.lat2, llb.lon2));
        ffaz += increment;
        if (ffaz>360) {
            ffaz -= 360;
        }
    }

    points.add(endPoint);
}

private void GRC(List<GeoPoint> points, GeoPoint geoPoint) {
    points.add(geoPoint);
}