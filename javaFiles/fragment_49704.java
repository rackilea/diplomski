final XYSeriesCollection coll = new XYSeriesCollection();
coll.addChangeListener(new DatasetChangeListener() {
    private int numberOfSeries = -1;

    @Override
    public void datasetChanged(DatasetChangeEvent arg0) {
        int numberOfSeriesNew = coll.getSeriesCount();
        if (numberOfSeriesNew == numberOfSeries) {
            // no series was added/removed
        } else if (numberOfSeriesNew < numberOfSeries) {
            // series was removed
            numberOfSeries = numberOfSeriesNew;
        } else {
            // series was added
            numberOfSeries = numberOfSeriesNew;
        }
    }
});