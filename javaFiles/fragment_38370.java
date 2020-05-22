import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import org.jfree.chart.*;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.XYItemLabelGenerator;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.AbstractXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.TextAnchor;

/** @see https://stackoverflow.com/a/14459322/230513 */
public class UnitPrice {

    private static XYDataset createDataset() {
        LabeledXYDataset ds = new LabeledXYDataset();
        ds.add(11,  0, "");
        ds.add(12, 68, "A");
        ds.add(13, 65, "B");
        ds.add(14, 67, "C");
        ds.add(15, 69, "D");
        ds.add(16, 60, "F");
        ds.add(17, 83, "G");
        ds.add(18, 86, "H");
        ds.add(19, 70, "I");
        ds.add(20, 60, "J");
        ds.add(21, 55, "K");
        ds.add(22, 54, "L");
        ds.add(23, 50, "M");
        return ds;
    }

    private static class LabeledXYDataset extends AbstractXYDataset {

        private static final int N = 26;
        private List<Number> x = new ArrayList<Number>(N);
        private List<Number> y = new ArrayList<Number>(N);
        private List<String> label = new ArrayList<String>(N);

        public void add(double x, double y, String label){
            this.x.add(x);
            this.y.add(y);
            this.label.add(label);
        }

        public String getLabel(int series, int item) {
            return label.get(item);
        }

        @Override
        public int getSeriesCount() {
            return 1;
        }

        @Override
        public Comparable getSeriesKey(int series) {
            return "Unit";
        }

        @Override
        public int getItemCount(int series) {
            return label.size();
        }

        @Override
        public Number getX(int series, int item) {
            return x.get(item);
        }

        @Override
        public Number getY(int series, int item) {
            return y.get(item);
        }
    }

    private static class LabelGenerator implements XYItemLabelGenerator {

        @Override
        public String generateLabel(XYDataset dataset, int series, int item) {
            LabeledXYDataset labelSource = (LabeledXYDataset) dataset;
            return labelSource.getLabel(series, item);
        }

    }

    private static JFreeChart createChart(final XYDataset dataset) {
        NumberAxis domain = new NumberAxis("Unit");
        NumberAxis range = new NumberAxis("Price");
        domain.setAutoRangeIncludesZero(false);
        XYItemRenderer renderer = new XYLineAndShapeRenderer(true, false);
        renderer.setBaseItemLabelGenerator(new LabelGenerator());
        renderer.setBaseItemLabelPaint(Color.green.darker());
        renderer.setBasePositiveItemLabelPosition(
            new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.CENTER));
        renderer.setBaseItemLabelFont(
            renderer.getBaseItemLabelFont().deriveFont(14f));
        renderer.setBaseItemLabelsVisible(true);
        renderer.setBaseToolTipGenerator(new StandardXYToolTipGenerator());
        XYPlot plot = new XYPlot(dataset, domain, range, renderer);
        JFreeChart chart = new JFreeChart(
            "Unit Price", JFreeChart.DEFAULT_TITLE_FONT, plot, false);
        return chart;
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        XYDataset dataset = createDataset();
        JFreeChart chart = createChart(dataset);
        ChartPanel chartPanel = new ChartPanel(chart) {

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(400, 320);
            }
        };
        f.add(chartPanel);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}