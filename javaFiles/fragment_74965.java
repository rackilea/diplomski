public static void main(String[] args) throws IOException {
    String lakes = "/data/natural_earth/10m_physical/ne_10m_lakes.shp";
    HashMap<String, Object> params = new HashMap<>();
    params.put("url", DataUtilities.fileToURL(new File(lakes)));
    DataStore ds = DataStoreFinder.getDataStore(params);

    String name = ds.getTypeNames()[0];
    SimpleFeatureSource source = ds.getFeatureSource(name);
    SimpleFeatureCollection features = source.getFeatures();
    NearestPolygon polyFinder = new NearestPolygon(features);
    for (int i = 0; i < 100; i++) {
      Point p = GenerateRandomData.createRandomPoint();
      Point pointOnLine = polyFinder.findNearestPolygon(p);
      if (!pointOnLine.isEmpty()) {
        System.out.println(i+" At " + pointOnLine + " is closest to " + p);
        SimpleFeature lastMatched2 = polyFinder.getLastMatched();
        String attribute = (String) lastMatched2.getAttribute("name");
        if(attribute.isEmpty()) {
          attribute = (String) lastMatched2.getAttribute("note");
        }
        if (((Geometry) (lastMatched2.getDefaultGeometry())).contains(p)) {
          System.out.println("is in lake " + attribute);
        } else {
          System.out.println("nearest lake is " + attribute);
        }

      }
    }
  }