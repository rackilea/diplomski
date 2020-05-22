File file = new File("example.shp");
Map map = new HashMap();
map.put( "url", file.toURL() );
DataStore dataStore = DataStoreFinder.getDataStore(map);

SimpleFeatureSource featureSource = dataStore.getFeatureSource( typeName );
SimpleFeatureCollection collection = featureSource.getFeatures();

ReferencedEnvelope env = collection.getBounds();
double left = env.getMinX();
double right = env.getMaxX();
double top = env.getMaxY();
double bottom = env.getMinY();