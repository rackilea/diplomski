import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import org.jfree.chart.*;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;

/** @See https://stackoverflow.com/a/30332903/230513 */
public class ChartPanelTest {

    private static final Random r = new Random();
    private static final TimeSeries series = new TimeSeries("Data");
    private static Day d = new Day();
    private static boolean flag = true;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame f = new JFrame();
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            series.add(d, 0);
            d = (Day) d.next();
            series.add(d, 0);
            XYDataset dataset = new TimeSeriesCollection(series);
            JFreeChart chart = ChartFactory.createTimeSeriesChart(
                "Test", "Day", "Value", dataset, false, false, false);
            ChartPanel chartPanel = new ChartPanel(chart) {
                @Override
                public Dimension getPreferredSize() {
                    return new Dimension(320, 240);
                }
            };
            f.add(chartPanel);
            f.add(new JButton(new AbstractAction("Add") {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (flag) {
                        series.addOrUpdate(d, r.nextGaussian());
                        flag = false;
                    } else {
                        d = (Day) d.next();
                        series.add(d, r.nextGaussian());
                    }
                }
            }), BorderLayout.SOUTH);
            f.pack();
            f.setLocationRelativeTo(null);
            f.setVisible(true);
        });
    }
}