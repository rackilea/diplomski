GeometryFactory gFactory = new GeometryFactory();
if (polygon.getNumInteriorRing() == 0){
  // polygon has not holes, so extract the exterior ring
  // and build a multilinestring
  return gFactory.createMultiLineString(polygon.getExteriorRing());
}

else{
  // Polygon has holes, also several boundaries. 
  // Simply run getBoundary(), it will return a multilinestring
  return polygon.getBoundary();
}