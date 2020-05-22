public String getNeighborhoodId(Coordinates c){
    GeometryFactory geometryFactory = new GeometryFactory();
    String utm = converter.latLon2UTM(c.getLat(), c.getLng());
    Coordinate coords = new Coordinate(Double.valueOf(utm.split(" ")[2]),Double.valueOf(utm.split(" ")[3]));
    Geometry point = geometryFactory.createPoint(coords);
    for(Feature f : neighborhoods){
        MultiPolygon m = (MultiPolygon) f.getProperty("geometry").getValue();
        if(m.contains(point)){
            return f.getProperty("neighborhoodId").getValue().toString();
        }
    }
    return "";
}