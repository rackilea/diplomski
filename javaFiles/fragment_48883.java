File f = new File("/home/ian/Data/states/states.shp");
    FileDataStore ds = FileDataStoreFinder.getDataStore(f);

    Filter filter = ECQL.toFilter("strEndsWith(\"STATE_NAME\",'a')=true");
    SimpleFeatureCollection collection = ds.getFeatureSource().getFeatures(filter);
    ArrayList<Geometry> geoms = new ArrayList<>();
    try (SimpleFeatureIterator it = collection.features()) {
      while (it.hasNext()) {
        SimpleFeature feature = it.next();
        Geometry geom = (Geometry) feature.getDefaultGeometry();

        geoms.add(geom);
      }
    }
    GeometryFactory gf = new GeometryFactory();
    GeometryCollection gc = gf.createGeometryCollection(geoms.toArray(new Geometry[] {}));
    gc = (GeometryCollection) Densifier.densify(gc, 5);
    double threshold = 10;
    ConcaveHull ch = new ConcaveHull(gc, threshold);
    Geometry concaveHull = ch.getConcaveHull();
    System.out.println(gc);
    System.out.println(concaveHull);