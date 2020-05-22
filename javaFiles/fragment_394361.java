XYPlot plot = (XYPlot) chart.getPlot();
ValueAxis axis = plot.getDomainAxis();
axis.setLowerBound(0);
XYBarRenderer r = (XYBarRenderer) plot.getRenderer();
r.setBarPainter(new StandardXYBarPainter());
r.setSeriesPaint(0, Color.blue);