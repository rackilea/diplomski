public class NearestPolygon {
  private static FilterFactory2 ff = CommonFactoryFinder.getFilterFactory2();
  private static GeometryFactory gf = new GeometryFactory();
  private SpatialIndexFeatureCollection index;
  private SimpleFeature lastMatched;

  public NearestPolygon(SimpleFeatureCollection features) {

    index = new SpatialIndexFeatureCollection(features.getSchema());
    index.addAll(features);
  }



  public Point findNearestPolygon(Point p) {
    final double MAX_SEARCH_DISTANCE = index.getBounds().getSpan(0);
    Coordinate coordinate = p.getCoordinate();
    ReferencedEnvelope search = new ReferencedEnvelope(new Envelope(coordinate),
        index.getSchema().getCoordinateReferenceSystem());
    search.expandBy(MAX_SEARCH_DISTANCE);
    BBOX bbox = ff.bbox(ff.property(index.getSchema().getGeometryDescriptor().getName()), (BoundingBox) search);
    SimpleFeatureCollection candidates = index.subCollection(bbox);

    double minDist = MAX_SEARCH_DISTANCE + 1.0e-6;
    Coordinate minDistPoint = null;
    try (SimpleFeatureIterator itr = candidates.features()) {
      while (itr.hasNext()) {

        SimpleFeature feature = itr.next();
        LocationIndexedLine line = new LocationIndexedLine(((MultiPolygon) feature.getDefaultGeometry()).getBoundary());
        LinearLocation here = line.project(coordinate);
        Coordinate point = line.extractPoint(here);
        double dist = point.distance(coordinate);
        if (dist < minDist) {
          minDist = dist;
          minDistPoint = point;
          lastMatched = feature;
        }
      }
    }
    Point ret = null;
    if (minDistPoint == null) {
      ret = gf.createPoint((Coordinate) null);
    } else {
      ret = gf.createPoint(minDistPoint);
    }
    return ret;
  }

  public SimpleFeature getLastMatched() {
    return lastMatched;
  }
}