import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PolarPlot;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/** @see http://stackoverflow.com/a/36846122/230513 */
public class Test {

    private final XYSeries series = new XYSeries("Series");
    private final XYDataset dataset = new XYSeriesCollection(series);

    public Test() {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JFreeChart chart = ChartFactory.createPolarChart(
            "Title", dataset, true, true, false);
        final PolarPlot plot = (PolarPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.white);
        plot.getAxis().setRange(0, 1);
        plot.getAxis().setTickLabelsVisible(false);
        plot.setAngleGridlinePaint(Color.black);
        plot.setRadiusGridlinePaint(Color.black);
        plot.setRadiusMinorGridlinesVisible(false);
        ChartPanel chartPanel = new ChartPanel(chart) {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(640, 480);
            }
        };

        JButton button = new JButton("Button");
        button.addActionListener(new ActionListener() {
            Random r = new Random();

            @Override
            public void actionPerformed(ActionEvent e) {
                series.clear();
                series.add(r.nextDouble() * 360, r.nextDouble());
            }
        });
        JPanel control = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        control.add(button);

        f.add(chartPanel, BorderLayout.CENTER);
        f.add(control, BorderLayout.SOUTH);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                Test t = new Test();
            }
        });
    }
}