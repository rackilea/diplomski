public class ItemAnnotationDemo {

    public static void main(String[] args) {
        int count = 20;
        double[][] data = new double[2][count];
        for(int i = 0; i < count; i++){
            data[0][i] = i;
            data[1][i] = i;
        }
        DefaultXYDataset dataset = new DefaultXYDataset();
        dataset.addSeries("Values", data);
        NumberAxis xAxis = new NumberAxis("x axis");
        NumberAxis yAxis = new NumberAxis("y axis");
        XYItemRenderer renderer = new XYLineAndShapeRenderer(true, true);
        renderer.addAnnotation(new XYItemAnnotation(
            new Rectangle2D.Double(-10, -8, 20, 16),
            new Color(128,128,128,128),
            new BasicStroke(3.0f),
            Color.RED,0,Integer.MAX_VALUE));
        XYPlot plot = new XYPlot(dataset, xAxis, yAxis, renderer);
        JFreeChart chart = new JFreeChart(plot);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new ChartPanel(chart));
        frame.pack();
        frame.setVisible(true);

    }
}
class XYItemAnnotation extends AbstractXYAnnotation{
    private Shape shape;
    private Paint outline;
    private Paint fill;
    private Stroke stroke;
    private int si;
    private int ii;
    public XYItemAnnotation(Shape shape, Paint fillPaint, Stroke outlineStroke, Paint outlinePaint, int seriesIndex, int itemIndex){
        super();
        this.shape = shape;
        this.fill = fillPaint;
        this.stroke = outlineStroke;
        this.outline = outlinePaint;
        this.si = seriesIndex;
        this.ii = itemIndex;
    }
    public void draw(Graphics2D g2, XYPlot plot, Rectangle2D dataArea, ValueAxis domainAxis, ValueAxis rangeAxis, int datasetIndex, PlotRenderingInfo info){
        XYDataset dataset = plot.getDataset(datasetIndex);
        if(dataset == null) return;
        if(si > dataset.getSeriesCount() - 1 ) return;
        int item = Math.max(0, ii);
        item = Math.min(item, dataset.getItemCount(si) - 1);
        double dx = dataset.getXValue(si, item);
        double dy = dataset.getYValue(si, item);
        if(Double.isNaN(dx) || Double.isNaN(dy)) return;
        if(!domainAxis.getRange().contains(dx) || !rangeAxis.getRange().contains(dy)) return;
        PlotOrientation orientation = plot.getOrientation();
        RectangleEdge domainEdge = Plot.resolveDomainAxisLocation(
                plot.getDomainAxisLocation(), orientation);
        RectangleEdge rangeEdge = Plot.resolveRangeAxisLocation(
                plot.getRangeAxisLocation(), orientation);

        double jx = domainAxis.valueToJava2D(dx, dataArea, domainEdge);
        double jy = rangeAxis.valueToJava2D(dy, dataArea, rangeEdge);
        if (orientation == PlotOrientation.HORIZONTAL) {
            double temp = jx;
            jx = jy;
            jy = temp;
        }
        Shape trans = ShapeUtilities.createTranslatedShape(shape, jx, jy);
        g2.setPaint(fill);
        g2.fill(trans);
        g2.setPaint(outline);
        g2.setStroke(stroke);
        g2.draw(trans);

    }
}