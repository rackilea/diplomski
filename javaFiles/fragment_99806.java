public boolean pointIsClose( File file, Point targetPoint,double distance) {


  boolean ret = false;
  Map connect = new HashMap();
  connect.put("url", file.toURL());
  DataStore dataStore = DataStoreFinder.getDataStore(connect);


  FeatureSource featureSource = dataStore.getFeatureSource(typeName);
  FeatureCollection collection = featureSource.getFeatures();
  FeatureIterator iterator = collection.features();



  try {
    while (iterator.hasNext()) {
      Feature feature = iterator.next();
      Geometry sourceGeometry = feature.getDefaultGeometry();
      ret= sourceGeometry.isWithinDistance(targetPoint, distance );
    }
  } finally {
    iterator.close();
  }
  return ret;
}