public static void drawCircle(MapboxMap map, LatLng position, int color, double radiusMeters) {
    PolylineOptions polylineOptions = new PolylineOptions();
    polylineOptions.color(color);
    polylineOptions.width(0.5f); // change the line width here
    polylineOptions.addAll(getCirclePoints(position, radiusMeters));
    map.addPolyline(polylineOptions);
}

private static ArrayList<LatLng> getCirclePoints(LatLng position, double radius) {
    int degreesBetweenPoints = 10; // change here for shape
    int numberOfPoints = (int) Math.floor(360 / degreesBetweenPoints);
    double distRadians = radius / 6371000.0; // earth radius in meters
    double centerLatRadians = position.getLatitude() * Math.PI / 180;
    double centerLonRadians = position.getLongitude() * Math.PI / 180;
    ArrayList<LatLng> polygons = new ArrayList<>(); // array to hold all the points
    for (int index = 0; index < numberOfPoints; index++) {
        double degrees = index * degreesBetweenPoints;
        double degreeRadians = degrees * Math.PI / 180;
        double pointLatRadians = Math.asin(sin(centerLatRadians) * cos(distRadians)
                + cos(centerLatRadians) * sin(distRadians) * cos(degreeRadians));
        double pointLonRadians = centerLonRadians + Math.atan2(sin(degreeRadians)
                        * sin(distRadians) * cos(centerLatRadians),
                cos(distRadians) - sin(centerLatRadians) * sin(pointLatRadians));
        double pointLat = pointLatRadians * 180 / Math.PI;
        double pointLon = pointLonRadians * 180 / Math.PI;
        LatLng point = new LatLng(pointLat, pointLon);
        polygons.add(point);
    }
    // add first point at end to close circle
    polygons.add(polygons.get(0));
    return polygons;
}