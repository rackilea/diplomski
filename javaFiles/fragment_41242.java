import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.util.*;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.XYDataItem;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 * @see http://stackoverflow.com/a/19749344/230513
 * @see http://stackoverflow.com/a/7208723/230513
 */
public class ScatterMove extends JFrame {

    private static final int N = 16;
    private static final String title = "Scatter Move Demo";
    private static final Random rand = new Random();
    private XYSeries moved = new XYSeries("Population");

    public ScatterMove(String s) {
        super(s);
        update();
        final ChartPanel chartPanel = createDemoPanel();
        this.add(chartPanel, BorderLayout.CENTER);
        JPanel control = new JPanel();
        control.add(new JButton(new AbstractAction("Move") {
            @Override
            public void actionPerformed(ActionEvent e) {
                moved.clear();
                update();
            }
        }));
        this.add(control, BorderLayout.SOUTH);
    }

    private void update() {
        for (int i = 0; i < N; i++) {
            moved.add(new XYDataItem(rand.nextGaussian(), rand.nextGaussian()));
        }
    }

    private ChartPanel createDemoPanel() {
        JFreeChart jfreechart = ChartFactory.createScatterPlot(
            title, "X", "Y", createSampleData(),
            PlotOrientation.VERTICAL, true, true, false);
        XYPlot xyPlot = (XYPlot) jfreechart.getPlot();
        XYItemRenderer renderer = xyPlot.getRenderer();
        NumberAxis domain = (NumberAxis) xyPlot.getDomainAxis();
        domain.setRange(-3.0, 3.0);
        domain.setTickUnit(new NumberTickUnit(1));
        NumberAxis range = (NumberAxis) xyPlot.getRangeAxis();
        range.setRange(-3.0, 3.0);
        range.setTickUnit(new NumberTickUnit(1));
        return new ChartPanel(jfreechart){

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(640, 480);
            }
        };
    }

    private XYDataset createSampleData() {
        XYSeriesCollection xySeriesCollection = new XYSeriesCollection();
        xySeriesCollection.addSeries(moved);
        return xySeriesCollection;
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                ScatterMove demo = new ScatterMove(title);
                demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                demo.pack();
                demo.setLocationRelativeTo(null);
                demo.setVisible(true);
            }
        });
    }
}