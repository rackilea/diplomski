static Geometry combineIntoOneGeometry()
{
    WKTReader wkt = new WKTReader();
    GeometryFactory geoFac = new GeometryFactory();
    ArrayList<Geometry> geometries = new ArrayList<>();

    try
    {
        Geometry polygon1 = wkt.read("POLYGON ((...))");
        Geometry polygon2 = wkt.read("POLYGON ((...))");
        Geometry polygon3 = wkt.read("POLYGON ((...))");
        Geometry polygon4 = wkt.read("POLYGON ((...))");
        geometries.add(polygon1);
        geometries.add(polygon2);
        geometries.add(polygon3);
        geometries.add(polygon4);
    }
    catch (ParseException e)
    {
        e.printStackTrace();
    }
    GeometryCollection geometryCollection = (GeometryCollection) geoFac.buildGeometry(geometries);

    return geometryCollection.union();
}