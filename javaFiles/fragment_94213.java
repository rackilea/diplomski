double x = xyPlot.getDomainAxis().java2DToValue(clickLocation.getX(), dataArea, xyPlot.getDomainAxisEdge());
double y = xyPlot.getRangeAxis().java2DToValue(clickLocation.getY(), dataArea, xyPlot.getRangeAxisEdge());
String text = Double.toString(x) + " " + Double.toString(y);

XYTextAnnotation annotation = new XYTextAnnotation(text, x, y);
plot.addAnnotation(annotation);