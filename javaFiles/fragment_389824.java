import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.ValueMarker;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class Plot extends ApplicationFrame {

    private static final long serialVersionUID = 1L;

    public Plot(String s) {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(jpanel);
    }

    private static CategoryDataset createDataset() {

        HashMap<String, Integer> hmap1 = new HashMap<String, Integer>();

        hmap1.put("S1", 6);
        hmap1.put("S2", 4);
        hmap1.put("S3", 5);
        hmap1.put("S4", 3);
        hmap1.put("S5", 2);

        DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
        for (Map.Entry<String, Integer> entry : hmap1.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            defaultcategorydataset.addValue(value, "Graph", key);
        }
        return defaultcategorydataset;
    }

    private static JFreeChart createChart(final CategoryDataset categorydataset) {
        int up = 9;
        int low = 2;
        int mid = 5;
        JFreeChart jfreechart = ChartFactory.createLineChart("", "X", "Y",
            categorydataset, PlotOrientation.VERTICAL, true, true, false);
        jfreechart.setBackgroundPaint(Color.white);

        CategoryPlot categoryplot = (CategoryPlot) jfreechart.getPlot();
        categoryplot.setBackgroundPaint(Color.lightGray);
        categoryplot.setRangeGridlinePaint(Color.lightGray);

        NumberAxis numberaxis = (NumberAxis) categoryplot.getRangeAxis();
        numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        numberaxis.setLowerBound(0);
        numberaxis.setUpperBound(up + 1);

        ValueMarker upper = new ValueMarker(up);
        upper.setPaint(Color.BLUE);
        categoryplot.addRangeMarker(upper);

        ValueMarker lower = new ValueMarker(low);
        lower.setPaint(Color.YELLOW);
        categoryplot.addRangeMarker(lower);

        ValueMarker middle = new ValueMarker(mid);
        middle.setPaint(Color.RED);
        categoryplot.addRangeMarker(middle);

        LineAndShapeRenderer lineandshaperenderer = new LineAndShapeRenderer() {
            @Override
            public Paint getItemPaint(int row, int col) {
                System.out.println(row + ", " + col);
                Paint cpaint = getItemColor(row, col);
                if (cpaint == null) {
                    cpaint = super.getItemPaint(row, col);
                }
                return cpaint;
            }

            public Color getItemColor(int row, int col) {
                int y = categorydataset.getValue(row, col).intValue();
                if (y <= low | y > up) {
                    return Color.black;
                }
                if (y <= mid) {
                    return Color.green;
                }
                if ((y <= up | y > low) & (y != mid)) {
                    return Color.yellow;
                }
                return null;
            }
        };
        lineandshaperenderer.setItemMargin(0);
        lineandshaperenderer.setSeriesShapesVisible(0, true);
        lineandshaperenderer.setSeriesLinesVisible(0, false);
        categoryplot.setRenderer(lineandshaperenderer);

        return jfreechart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jfreechart = createChart(createDataset());
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[]) {
        Plot plot = new Plot("Plot");
        plot.pack();
        RefineryUtilities.centerFrameOnScreen(plot);
        plot.setVisible(true);
    }
}