import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Paint;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.DateTickMarkPosition;
import org.jfree.chart.axis.DateTickUnit;
import org.jfree.chart.axis.DateTickUnitType;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYBarPainter;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.data.Range;
import org.jfree.data.general.DatasetUtils;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.Year;
import org.jfree.data.xy.IntervalXYDataset;

/**
 * @see https://stackoverflow.com/a/54680803/230513
 * @see https://stackoverflow.com/a/54362133/230513
 * @see https://stackoverflow.com/a/42612723/230513
 */
public class Test {

    private static final int N = 5;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Test()::display);
    }

    private void display() {
        JFrame f = new JFrame("Data");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        IntervalXYDataset dataset = createDataset();
        JFreeChart chart = ChartFactory.createXYBarChart("Data", "Time", true,
            "Value", dataset, PlotOrientation.VERTICAL, false, false, false);
        XYPlot plot = chart.getXYPlot();
        XYBarRenderer r = new MyXYBarRenderer(dataset);
        r.setDrawBarOutline(true);
        r.setBarPainter(new StandardXYBarPainter());
        plot.setRenderer(r);
        f.add(createPanel(chart));
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    private class MyXYBarRenderer extends XYBarRenderer {

        private final IntervalXYDataset dataset;

        public MyXYBarRenderer(IntervalXYDataset dataset) {
            this.dataset = dataset;
        }

        @Override
        public Paint getItemPaint(int row, int col) {
            double value = dataset.getYValue(row, col);
            Range r = DatasetUtils.findRangeBounds(dataset);
            double range = r.getUpperBound() - r.getLowerBound() + 1;
            float scaled = (float) (value / range);
            return Color.getHSBColor(2f / 3, 1 - scaled, 1);
        }
    }

    private ChartPanel createPanel(JFreeChart chart) {
        final XYPlot plot = chart.getXYPlot();
        final DateAxis domainAxis = (DateAxis) plot.getDomainAxis();
        domainAxis.setTickUnit(new DateTickUnit(DateTickUnitType.YEAR, 1));
        domainAxis.setTickMarkPosition(DateTickMarkPosition.MIDDLE);
        domainAxis.setDateFormatOverride(new SimpleDateFormat("yyyy"));
        return new ChartPanel(chart) {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(500, 250);
            }
        };
    }

    private IntervalXYDataset createDataset() {
        TimeSeries series = new TimeSeries("Value");
        Calendar c = Calendar.getInstance();
        for (int i = 0; i < N; i++) {
            series.add(new Year(c.getTime()), i + 1);
            c.add(Calendar.YEAR, 1);
        }
        for (int i = 1; i < N; i++) {
            series.add(new Year(c.getTime()), N - i);
            c.add(Calendar.YEAR, 1);
        }
        return new TimeSeriesCollection(series);
    }
}