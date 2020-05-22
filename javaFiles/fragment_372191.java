public JFreeChart createChart(String axisX, String axisY){

    JFreeChart chart = ChartFactory.createTimeSeriesChart(null, axisX, axisY, dataSeries, true, true, false);

    final XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
    renderer.setSeriesLinesVisible(0,true);
    renderer.setSeriesShapesVisible(0, true);

    //percentage (y-axis)
    final NumberAxis percentAxis = new NumberAxis(axisY);
    percentAxis.setInverted(false);
    percentAxis.setRange(0.0, 100.0);

    //time (x-axis)
    final DateAxis timeAxis = new DateAxis(axisX);
    timeAxis.setStandardTickUnits(DateAxis.createStandardDateTickUnits(TimeZone.getDefault(), Locale.ENGLISH));

    double range = 0;

    switch (format){
        case ONE_MINUTE_RANGE: range = 60*1000; break;
        case TEN_MINUTE_RANGE: range = 10*60*1000; break;
        case ONE_HOUR_RANGE: range = 60*60*1000; break;
    }

    timeAxis.setRange(System.currentTimeMillis()-range/2, System.currentTimeMillis()+range/2); //time duration based on format chosen

    XYPlot plot = chart.getXYPlot();
    plot.setDomainAxis(timeAxis);
    plot.setRangeAxis(percentAxis);

    plot.setBackgroundPaint(Color.white);
    plot.setRangeGridlinePaint(Color.gray);
    plot.setRangeZeroBaselinePaint(Color.gray);
    plot.setDomainGridlinePaint(Color.gray);
    plot.setForegroundAlpha(0.5f);
    plot.setRenderer(renderer);

    chart.setBackgroundPaint(Color.white);

    return chart;
}