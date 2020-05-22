import java.awt.Dimension;
import java.util.Random;
import javax.swing.JFrame;
import org.jfree.chart.*;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.util.ShapeUtilities;

/** @see https://stackoverflow.com/a/14822991/230513 */
public class Test {

    private static final int N = 16;
    private static final Random random = new Random();

    private static XYDataset createDataset() {

        final TimeSeries series = new TimeSeries("Data");
        Day current = new Day();
        for (int i = 0; i < N; i++) {
            series.add(current, Math.abs(random.nextGaussian()));
            current = (Day) current.next();
        }
        return new TimeSeriesCollection(series);
    }

    private static JFreeChart createChart(final XYDataset dataset) {
        JFreeChart chart = ChartFactory.createTimeSeriesChart(
            "Test", "Day", "Value", dataset, false, false, false);
        XYPlot plot = (XYPlot) chart.getPlot();
        XYLineAndShapeRenderer r = (XYLineAndShapeRenderer) plot.getRenderer();
        r.setSeriesShape(0, ShapeUtilities.createDiamond(5));
        r.setSeriesShapesVisible(0, true);
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
                return new Dimension(630, 480);
            }
        };
        f.add(chartPanel);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}