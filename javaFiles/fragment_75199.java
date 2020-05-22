XYPlot plot = chart.getXYPlot();
NumberAxis xAxis = (NumberAxis) plot.getDomainAxis();
xAxis.setTickUnit(new NumberTickUnit(10));

NumberAxis yAxis = (NumberAxis) plot.getRangeAxis();
yAxis.setTickUnit(new NumberTickUnit(1));