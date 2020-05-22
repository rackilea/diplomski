ConvexHull cx = new ConvexHull(geoPoints);
Point C1[] = cx.getConvexHull();

List<GeoPoint> points = new ArrayList<GeoPoint>(C1.length);
for (int i = 0; i < C1.length; ++i) {
  points.add(new GeoPoint(C1[i].getX(), C1[i].getY()));
}
polygon.setPoints(points);