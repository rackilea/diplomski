ChartEntity ce = cme.getEntity();
if (ce instanceof XYItemEntity) {
    XYItemEntity e = (XYItemEntity) ce;
    System.out.println("Dataset: " + e.getDataset());
    System.out.println("Series index: " + e.getSeriesIndex());
}