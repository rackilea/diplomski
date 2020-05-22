import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Paint;
import java.awt.Shape;
import javax.swing.JFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.PaintScale;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.PaintScaleLegend;
import org.jfree.data.Range;
import org.jfree.data.xy.DefaultXYZDataset;
import org.jfree.data.xy.XYZDataset;
import org.jfree.chart.ui.RectangleEdge;
import org.jfree.chart.ui.RectangleInsets;
import org.jfree.chart.util.ShapeUtils;
import org.jfree.data.general.DatasetUtils;

/**
 * @see https://stackoverflow.com/a/54180207/230513
 * @see https://stackoverflow.com/a/37235165/230513
 */
public class Plot2D {

    public static JFreeChart createChart(XYZDataset dataset,
        String title, String x, String y, String z, Range r) {
        NumberAxis xAxis = new NumberAxis(x);
        xAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        NumberAxis yAxis = new NumberAxis(y);
        yAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        SpectrumPaintScale scale = new SpectrumPaintScale(r);
        NumberAxis scaleAxis = new NumberAxis(z);
        scaleAxis.setAxisLinePaint(Color.white);
        scaleAxis.setTickMarkPaint(Color.white);
        PaintScaleLegend legend = new PaintScaleLegend(scale, scaleAxis);
        legend.setSubdivisionCount(128);
        legend.setAxisLocation(AxisLocation.TOP_OR_RIGHT);
        legend.setPadding(new RectangleInsets(10, 10, 10, 10));
        legend.setStripWidth(20);
        legend.setPosition(RectangleEdge.RIGHT);
        legend.setBackgroundPaint(Color.WHITE);
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer(false, true) {
            @Override
            public Paint getItemFillPaint(int row, int col) {
                return scale.getPaint(dataset.getZValue(row, col));
            }

            @Override
            public Shape getItemShape(int row, int col) {
                return ShapeUtils.createDiagonalCross(5, 2);
            }
        };
        renderer.setUseFillPaint(true);
        renderer.setSeriesShapesFilled(0, true);
        renderer.setSeriesShapesVisible(0, true);
        XYPlot plot = new XYPlot(dataset, xAxis, yAxis, renderer);
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinesVisible(false);
        plot.setRangeGridlinePaint(Color.white);
        plot.setRenderer((renderer));

        JFreeChart chart = new JFreeChart(title, plot);
        chart.addSubtitle(legend);
        chart.removeLegend();
        chart.setBackgroundPaint(Color.white);

        return chart;
    }

    private static class SpectrumPaintScale implements PaintScale {

        private static final float H1 = 0f;
        private static final float H2 = (float) (Math.PI / 8);
        private final Range range;

        public SpectrumPaintScale(Range r) {
            this.range = r;
        }

        @Override
        public double getLowerBound() {
            return range.getLowerBound();
        }

        @Override
        public double getUpperBound() {
            return range.getUpperBound();
        }

        @Override
        public Paint getPaint(double value) {
            float scaledValue = (float) (value / (getUpperBound() - getLowerBound()));
            float scaledH = H1 + scaledValue * (H2 - H1);
            return Color.getHSBColor(scaledH, 1f, 1f);
        }
    }

    public static void main(String[] args) {
        double xyz[][] = {
            {    1,    2,    3,    4,    5 }, // x
            { 1000, 3000, 9215, 4000, 1000 }, // y
            { 1341,  500, 3125, 1000, 7022 }  // z
        };
        final DefaultXYZDataset dataset = new DefaultXYZDataset();
        dataset.addSeries("Series", xyz);
        Range r = DatasetUtils.findZBounds(dataset);
        EventQueue.invokeLater(() -> {
            JFrame f = new JFrame("Color Map");
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JFreeChart chart = Plot2D.createChart(dataset, "Color Map",
                "Order Call", "Time in Ms", "Size in Ko", r);
            f.add(new ChartPanel(chart) {
                @Override
                public Dimension getPreferredSize() {
                    return new Dimension(600, 300);
                }
            });
            f.pack();
            f.setLocationRelativeTo(null);
            f.setVisible(true);
        });
    }
}