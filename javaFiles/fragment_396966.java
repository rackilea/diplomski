ValueMarker marker = new ValueMarker(position);  // position is the value on the axis
marker.setPaint(Color.black);
//marker.setLabel("here"); // see JavaDoc for labels, colors, strokes

XYPlot plot = (XYPlot) chart.getPlot();
plot.addDomainMarker(marker);