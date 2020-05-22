try {
     while (iterator.hasNext()) {
         SimpleFeature feature = iterator.next();
         Property intptlat = feature.getProperty("TRACTCE");
     }
 }