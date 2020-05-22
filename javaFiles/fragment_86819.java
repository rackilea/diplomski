import java.awt.Color;
import java.awt.EventQueue;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.Hour;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

/**
 * @see https://stackoverflow.com/a/55584636/230513
 * @see https://stackoverflow.com/q/55553082/230513
 */
public class HourTest {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MMM HH");
    private static final int DAYS = 1;

    private Calendar getCalendar() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);return c;
    }

    private void display() {
        JFrame f = new JFrame("HourTest");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        TimeSeries timeSeries = new TimeSeries("Number of visitors");
        TimeSeries refSeries = new TimeSeries("Reference number of visitors");
        Calendar c1 = getCalendar();
        Calendar c2 = getCalendar();
        c2.add(Calendar.DAY_OF_YEAR, -DAYS);
        for (int i = 0; i < 24 * DAYS; i++) {
            timeSeries.add(new Hour(c1.getTime()), i + 2);
            c1.add(Calendar.HOUR, 1);
            refSeries.add(new Hour(c2.getTime()), i + 1);
            c2.add(Calendar.HOUR, 1);
        }
        TimeSeriesCollection dataset = new TimeSeriesCollection(timeSeries);
        TimeSeriesCollection refDataset = new TimeSeriesCollection(refSeries);
        NumberAxis valueAxis = new NumberAxis("Number of visitors");
        valueAxis.setAutoRangeIncludesZero(false);
        DateAxis timeAxis = new DateAxis("Hours");
        timeAxis.setDateFormatOverride(DATE_FORMAT);
        DateAxis refAxis = new DateAxis("Reference hours");
        refAxis.setDateFormatOverride(DATE_FORMAT);
        XYPlot plot = new XYPlot(dataset, timeAxis, valueAxis, null);
        plot.setBackgroundPaint(Color.WHITE);
        plot.setDomainGridlinePaint(Color.LIGHT_GRAY);
        plot.setRangeGridlinePaint(Color.LIGHT_GRAY);
        plot.setDomainAxis(1, refAxis);
        plot.setDomainAxisLocation(1, AxisLocation.BOTTOM_OR_RIGHT);
        plot.setDataset(1, refDataset);
        plot.mapDatasetToDomainAxis(1, 1);
        XYLineAndShapeRenderer renderer0 = new XYLineAndShapeRenderer();
        renderer0.setSeriesPaint(0, Color.red);
        XYLineAndShapeRenderer renderer1 = new XYLineAndShapeRenderer();
        renderer1.setSeriesPaint(0, Color.blue);
        plot.setRenderer(0, renderer0);
        plot.setRenderer(1, renderer1);
        plot.setDomainPannable(true);
        plot.setRangePannable(true);
        JFreeChart timeChart = new JFreeChart("Main stats", plot);
        timeChart.setBackgroundPaint(Color.white);

        f.add(new ChartPanel(timeChart));
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new HourTest()::display);
    }
}