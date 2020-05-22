static void addFill(Plot plot) {

    XYSeries lowerLimitSeries = ((XYSeriesCollection) (plot.getDataset())).getSeries(1);
    XYSeriesCollection fillSet = new XYSeriesCollection();
    double lowerBound = plot.getRangeAxis().getLowerBound();
    fillSet.addSeries(lowerLimitSeries);
    fillSet.addSeries(createLowerFillSeries(lowerLimitSeries, lowerBound));
    plot.setDataset(1, fillSet);
    Paint fillPaint = Color.GREEN;
    XYDifferenceRenderer fillRenderer = new XYDifferenceRenderer(fillPaint, fillPaint, false);
    fillRenderer.setSeriesStroke(0, new BasicStroke(0)); //do not show
    fillRenderer.setSeriesStroke(1, new BasicStroke(0)); //do not show
    plot.setRenderer(1, fillRenderer);
    ...
}

static XYSeries createLowerFillSeries(XYSeries lowerLimitSeries, double lowerLimit) {
    int size = lowerLimitSeries.getItems().size();
    XYSeries res = new XYSeries("lowerFillSeries");
    for (int i = 0; i < size; i++) res.add(new XYDataItem(lowerLimitSeries.getX(i), lowerLimit));
    return res;
}