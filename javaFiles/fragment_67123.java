import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimePeriodValues;
import org.jfree.data.time.TimePeriodValuesCollection;

/**
 * @see http://stackoverflow.com/a/12065474/230513
 */
public class DisappearingTest {

    private static ChartPanel chartPanel;
    private static ValueAxis range;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                buildFrame();
            }
        });
    }

    private static void buildFrame() {
        JFrame f = new JFrame("Test");
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        initChartPanel();
        f.add(chartPanel, BorderLayout.CENTER);
        JPanel panel = new JPanel();
        panel.add(new JButton(new AbstractAction("Reset") {

            @Override
            public void actionPerformed(ActionEvent e) {
                chartPanel.restoreAutoBounds();
                range.setLowerBound(0);
                range.setUpperBound(1);
            }
        }));
        f.add(panel, BorderLayout.SOUTH);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    static void initChartPanel() {
        TimePeriodValues values = new TimePeriodValues("Test");
        values.add(new Day(1, 1, 2012), 0.2);
        values.add(new Day(2, 1, 2012), 0.2);
        values.add(new Day(3, 1, 2012), 0.8);
        values.add(new Day(1, 2, 2012), 0.8);
        TimePeriodValuesCollection data = new TimePeriodValuesCollection();
        data.addSeries(values);
        JFreeChart chart = ChartFactory.createTimeSeriesChart(
            "Title", "Time", "Value", data, true, true, false);
        XYPlot plot = chart.getXYPlot();
        plot.setDomainPannable(true);
        range = plot.getRangeAxis();
        range.setLowerBound(0);
        range.setUpperBound(1);
        chartPanel = new ChartPanel(chart);
        chartPanel.setMouseWheelEnabled(true);
    }
}