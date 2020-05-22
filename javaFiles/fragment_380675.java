File FilePath = new File("/users/New File abc.shp");
 FileDataStore ds = FileDataStoreFinder.getDataStore(new File(FilePath.toString()));
    SimpleFeatureType schema = ds.getSchema();
    // create new schema
    SimpleFeatureTypeBuilder builder = new SimpleFeatureTypeBuilder();
    builder.setName(schema.getName().toString().replaceAll("%20", "_").replaceAll(" ", "_"));
    builder.setSuperType((SimpleFeatureType) schema.getSuper());
    builder.addAll(schema.getAttributeDescriptors());

    // build new schema
    SimpleFeatureType nSchema = builder.buildFeatureType();
    System.out.println("Shapefile table info : " + nSchema);