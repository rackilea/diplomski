public final class GeometryUtil {
    /**
        https://www.cfa.harvard.edu/~dfabricant/huchra/ay145/constants.html
        1 Earth Radius = 6.37814x108 cm = 6.37814x10^6 m (Equatorial)
     */
    public static final double EARTH_RADIUS_IN_METERS = 6.37814e+6;

    private GeometryUtil(){}

    /**
     * @param geoPoint is a point of some object you want to translate to Cartesian.
     * @param geoPointRelative is a point of relative center.
     *                         We suppose that this relative GeoPoint is a center for the first parameter.
     * */
    public static Coordinate toCoordinate(GeoPoint geoPoint, GeoPoint geoPointRelative){
        return new Coordinate(toX(geoPoint, geoPointRelative.getLongitude()),
                              toY(geoPoint, geoPointRelative.getLatitude()));
    }

    public static double toX(GeoPoint geoPoint, double relativeLongitude){
        return  EARTH_RADIUS_IN_METERS *
                cos(toRadians(geoPoint.getLatitude()))  *
                toRadians(geoPoint.getLongitude()- relativeLongitude);
    }

    public static double toY(GeoPoint geoPoint, double relativeLatitude){
        return  EARTH_RADIUS_IN_METERS * toRadians(geoPoint.getLatitude() - relativeLatitude);
    }

}