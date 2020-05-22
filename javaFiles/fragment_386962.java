try (SimpleFeatureIterator itr = pointFeatures.getFeatures().features()) { 
  while (itr.hasNext()) {
    SimpleFeature f = itr.next();
    Geometry snapee = (Geometry) f.getDefaultGeometry();
    Filter filter = ECQL.toFilter("DWITH(\"the_geom\",'" + writer.write(snapee) + "'," + MAX_SEARCH_DISTANCE + ")");
    SimpleFeatureCollection possibles = indexed.subCollection(filter);
    double minDist = Double.POSITIVE_INFINITY;
    SimpleFeature bestFit = null;
    Coordinate bestPoint = null;
    try (SimpleFeatureIterator pItr = possibles.features()) {
      while (pItr.hasNext()) {
        SimpleFeature p = pItr.next();
        Geometry line = (Geometry) p.getDefaultGeometry();

        double dist = snapee.distance(line);
        if (dist < minDist) {
          minDist = dist;
          bestPoint = DistanceOp.nearestPoints(snapee, line)[1];
          bestFit  = p;
        }
      }
    }