//Mock data
DefaultCategoryDataset dataset = new DefaultCategoryDataset();
int[] times = new int[]{1,2,3,4,5,6,7,8,9};
for ( int i = 0; i < times.length; i++ ){
    dataset.addValue(times[i], "Time", "Hour" + String.valueOf(i+1));
}

//create the plot
CategoryPlot plot = new CategoryPlot();

//add the first dataset, and render as bar values
CategoryItemRenderer renderer = new BarRenderer();
plot.setDataset(0,dataset);
plot.setRenderer(0,renderer);  

//add the second dataset, render as lines
CategoryItemRenderer renderer2 = new LineAndShapeRenderer();
plot.setDataset(1, dataset);
plot.setRenderer(1, renderer2);

//set axis 
plot.setDomainAxis(new CategoryAxis("Time"));
plot.setRangeAxis(new NumberAxis("Value"));