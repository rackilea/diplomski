//modify public LineSegment scaleByFactor(double scalar) {
public double scaleByFactor(double scalar) {
  scalarX = x2 + (x2 - x1) * length;
  scalarY = y2 + (y2 - x1) * length;
  return scalar;
}