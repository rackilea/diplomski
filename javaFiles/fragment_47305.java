// series
addSeries1();
OHLCSeries series = seriesCollection.getSeries(0);
OHLCItem item = (OHLCItem) series.getDataItem(1);
RegularTimePeriod t = item.getPeriod();
long x = t.getFirstMillisecond();
long w = t.getLastMillisecond() - t.getFirstMillisecond(); 
double y = item.getLowValue();
double h = item.getHighValue() - y;
XYShapeAnnotation a1 = new XYShapeAnnotation(
    new Rectangle2D.Double(x, y, w, h),
    new BasicStroke(1f), Color.blue
);
chart.getXYPlot().addAnnotation(a1);