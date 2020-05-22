public JFreeChart createChart() {

    String title = "MyChart";

    IntervalXYDataset dataset1;
    dataset1 = createDataset();
    XYBarRenderer renderer1 = new XYBarRenderer(0.20000000000000001D);
    renderer1.setBaseToolTipGenerator(new StandardXYToolTipGenerator("{0}: ({1}, {2})", new SimpleDateFormat("EE, d-MMM-yyyy"), new DecimalFormat("0.00")));
    renderer1.setSeriesPaint(0, Color.BLUE);
    renderer1.setDefaultShadowsVisible(false);
    DateAxis domainAxis = new DateAxis("Datum");
    domainAxis.setTickMarkPosition(DateTickMarkPosition.MIDDLE);
    NumberAxis valueAxis = new NumberAxis("Anzahl");
    XYPlot plot = new XYPlot(dataset1, domainAxis, valueAxis, renderer1);
    XYDataset dataset2 = createBettenDataset();
    StandardXYItemRenderer renderer2 = new StandardXYItemRenderer();
    renderer2.setBaseToolTipGenerator(new StandardXYToolTipGenerator("{0}: ({1}, {2})", new SimpleDateFormat("EE, d-MMM-yyyy"), new DecimalFormat("0.00")));
    renderer2.setSeriesPaint(0, Color.CYAN);
    renderer2.setSeriesStroke(0, new BasicStroke(2));
    plot.setDataset(1, dataset2);
    plot.setRenderer(1, renderer2);
    XYDataset dataset3 = createMaxBelegungDataset();
    StandardXYItemRenderer renderer3 = new StandardXYItemRenderer();
    renderer3.setBaseToolTipGenerator(new StandardXYToolTipGenerator("{0}: ({1}, {2})", new SimpleDateFormat("EE, d-MMM-yyyy"), new DecimalFormat("0.00")));
    renderer3.setSeriesPaint(0, Color.RED);
    renderer3.setSeriesStroke(0, new BasicStroke(4));
    plot.setDataset(2, dataset3);
    plot.setRenderer(2, renderer3);

    plot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);

    JFreeChart chart = new JFreeChart(title, JFreeChart.DEFAULT_TITLE_FONT, plot, true);

    return chart;

}