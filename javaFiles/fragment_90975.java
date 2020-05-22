public class BarColorCustomizer implements JRChartCustomizer {

    @Override
    public void customize(JFreeChart jfchart, JRChart jrchart) {
        //Get the plot
        CategoryPlot  plot = jfchart.getCategoryPlot();
        //Get the dataset
        CategoryDataset dataSet = plot.getDataset();
        //Loop the row count (our series)
        int rowCount = dataSet.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            Comparable<?> rowKey = dataSet.getRowKey(i);
            //Get a custom paint for our series key
            Paint p = getCustomPaint(rowKey);
            if (p!=null){
                //set the new paint to the renderer
                plot.getRenderer().setSeriesPaint(i, p);
            }
        }

    }

    //Example of simple implementation returning Color on basis of value
    private Paint getCustomPaint(Comparable<?> rowKey) {
        if ("JANUARY".equals(rowKey)){
            return Color.BLACK;
        }
        return null;
    }
}