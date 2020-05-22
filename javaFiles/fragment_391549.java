private XYDataset createDataset() {
    TimeSeriesCollection tsc = new TimeSeriesCollection();
    for (int i = 1; i < 6; i++) {
        tsc.addSeries(createSeries("Series " + String.valueOf(i), i * 100));
    }
    return tsc;
}