public final class GeometryBuilder {

    private static final int DIAMETER_MULTIPLIER = 2;
    private static final int TURN_LEFT = 90;    //We should start to roll to the right from "North"/"Up"/12 o'clock

    private GeometryBuilder(){}


    public static Circle buildCirlce(GeoPoint centerOfCircle, GeoPoint relativeCenter, Distance radiusDistance){
        GeometricShapeFactory geometricShapeFactory = new GeometricShapeFactory();
        geometricShapeFactory.setCentre(GeometryUtil.toCoordinate(centerOfCircle, relativeCenter));
        geometricShapeFactory.setSize(radiusDistance.getMeters() * DIAMETER_MULTIPLIER);
        return new Circle(geometricShapeFactory.createEllipse());
    }


     public static Sector buildGSMCellSector(GSMCellLocation gsmCellLocation, GeoPoint relativeCenter){
        GeometricShapeFactory geometricShapeFactory = new GeometricShapeFactory();
        geometricShapeFactory.setCentre(GeometryUtil.toCoordinate(gsmCellLocation.getGeoPoint(), relativeCenter));
        geometricShapeFactory.setSize(gsmCellLocation.getMidDist() * DIAMETER_MULTIPLIER);
        return new Sector(geometricShapeFactory.createArcPolygon(-toRadians(gsmCellLocation.getEndAngle()- TURN_LEFT),
                                                                  toRadians(gsmCellLocation.getAngleWidth())));
    }
}