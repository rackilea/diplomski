double minXInAxis = xAxis.getDisplayPosition(xAxis.getLowerBound());
double maxXInAxis = xAxis.getDisplayPosition(xAxis.getUpperBound());
double minYInAxis = yAxis.getDisplayPosition(yAxis.getLowerBound());
double maxYInAxis = yAxis.getDisplayPosition(yAxis.getUpperBound());

double minX = sceneToLocal(xAxis.localToScene(new Point2D(minXInAxis,0))).getX();
double maxX = sceneToLocal(xAxis.localToScene(new Point2D(maxXInAxis,0))).getX();
double minY = sceneToLocal(yAxis.localToScene(new Point2D(0,minYInAxis))).getY();
double maxY = sceneToLocal(yAxis.localToScene(new Point2D(0,maxYInAxis))).getY();