//Add the otherDataSet to the plot and map it to the same axis at the original plot 
int index = 1;
plot.setDataset(index, otherDataSet);
plot.mapDatasetToRangeAxis(index, 0);

XYItemRenderer renderer2 = new XYLineAndShapeRenderer();
plot.setRenderer(1, renderer2);
plot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);