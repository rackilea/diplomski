...
XYDataset dataset = createDataset();
JFreeChart chart = createChart(dataset);
CategoryAxis categoryAxis = chart.getCategoryPlot().getDomainAxis();
categoryAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_90);
// categoryAxis.setVerticalTickLabels(true);
...