import java.awt.EventQueue;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.DateTickMarkPosition;
import org.jfree.chart.axis.DateTickUnit;
import org.jfree.chart.axis.DateTickUnitType;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.time.Hour;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.IntervalXYDataset;

/** @see https://stackoverflow.com/a/42612723/230513 */
public class Test {

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            Test frame = new Test();
        });
    }

    public Test() {
        JFrame f = new JFrame("Data");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new ChartAdapter().generateChart("Data"));
        f.pack();
        f.setVisible(true);
    }

    class ChartAdapter {

        public ChartPanel generateChart(String title) {
            JFreeChart chart = ChartFactory.createXYBarChart(
                title, "Time", true, "Value", createDataset(),
                PlotOrientation.VERTICAL, true, false, false
            );
            final XYItemRenderer renderer = chart.getXYPlot().getRenderer();
            final StandardXYToolTipGenerator generator = new StandardXYToolTipGenerator(
                "{1} : {2}", new SimpleDateFormat("HH:mm"), new DecimalFormat("0.00")
            );
            renderer.setBaseToolTipGenerator(generator);
            final XYPlot plot = chart.getXYPlot();
            final DateAxis domainAxis = (DateAxis) plot.getDomainAxis();
            domainAxis.setVerticalTickLabels(true);
            domainAxis.setTickUnit(new DateTickUnit(DateTickUnitType.HOUR, 1));
            domainAxis.setTickMarkPosition(DateTickMarkPosition.MIDDLE);
            domainAxis.setDateFormatOverride(new SimpleDateFormat("HH:mm"));
            return new ChartPanel(chart);
        }

        private IntervalXYDataset createDataset() {
            Random r = new Random();
            TimeSeries series = new TimeSeries("Value");
            Calendar c = Calendar.getInstance();
            for (int i = 0; i < 10; i++) {
                series.add(new Hour(c.getTime()), r.nextGaussian() + 7);
                c.add(Calendar.HOUR, 1);
            }
            return new TimeSeriesCollection(series);
        }
    }
}