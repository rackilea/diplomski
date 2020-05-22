renderer.setBaseToolTipGenerator(new StandardXYToolTipGenerator(
        "{0}: {1}…{2}", NumberFormat.getInstance(), NumberFormat.getInstance()) {
    @Override
    protected Object[] createItemArray(XYDataset data, int series, int item) {
        YIntervalSeriesCollection d = (YIntervalSeriesCollection) data;
        Object[] result = new Object[3];
        double y = d.getYValue(series, item);
        result[0] = getYFormat().format(y);
        double min = d.getStartYValue(series, item);
        result[1] = getYFormat().format(min);
        double max = d.getEndYValue(series, item);
        result[2] = getYFormat().format(max);
        return result;
    }
});