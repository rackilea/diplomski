JAXBContext jc = JAXBContext.newInstance(Kml.class);

// create KML reader to parse arbitrary KML into Java Object structure
Unmarshaller u = jc.createUnmarshaller();
Kml kml = (Kml) u.unmarshal(new File("test.kml"));

Placemark placemark = (Placemark) kml.getFeature();
Polygon geom = (Polygon) placemark.getGeometry();
LinearRing linearRing = geom.getOuterBoundaryIs().getLinearRing();
List<Coordinate> coordinates = linearRing.getCoordinates();
for (Coordinate coordinate : coordinates) {
    System.out.println(coordinate.getLongitude());
    System.out.println(coordinate.getLatitude());
    System.out.println(coordinate.getAltitude());
}