private static CategoryDataset createDataset() {
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    dataset.addValue(15, "Series 1", "12-04-2012");
    dataset.addValue(12, "Series 1", "13-04-2012");
    dataset.addValue(10, "Series 1", "15-04-2012");
    dataset.addValue(5,  "Series 1",  "16-04-2012");
    return dataset;
}