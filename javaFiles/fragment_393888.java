private static JFreeChart createClusteredChart(String title, String categoryAxisLabel, String valueAxisLabel, IntervalXYDataset dataset) {

  NumberAxis domainAxis = new NumberAxis(categoryAxisLabel);
  domainAxis.setAutoRangeIncludesZero(false);

  ValueAxis valueAxis = new NumberAxis(valueAxisLabel);

  XYBarRenderer renderer = new ClusteredXYBarRenderer();

  XYPlot plot = new XYPlot(dataset, domainAxis, valueAxis, renderer);
  plot.setOrientation(PlotOrientation.VERTICAL);

  JFreeChart chart = new JFreeChart(title, JFreeChart.DEFAULT_TITLE_FONT, plot, true);

  return chart;
}