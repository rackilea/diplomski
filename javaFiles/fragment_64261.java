import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CenterTextMode;
import org.jfree.chart.plot.RingPlot;
import org.jfree.data.general.DefaultPieDataset;

/**
 * @see https://stackoverflow.com/a/56672573/230513
 * @see https://stackoverflow.com/a/37414338/230513
 */
public class TestRing {

    private void display() {
        JFrame f = new JFrame("Test");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Critical", new Integer(42));
        dataset.setValue("Important", new Integer(21));
        dataset.setValue("Moderate", new Integer(7));
        dataset.setValue("Low", new Integer(3));
        JFreeChart chart = ChartFactory.createRingChart(
            "Test", dataset, false, true, false);
        RingPlot pie = (RingPlot) chart.getPlot();
        pie.setSimpleLabels(true);
        pie.setCenterTextMode(CenterTextMode.VALUE);
        pie.setCenterTextFont(pie.getCenterTextFont().deriveFont(Font.BOLD, 30f));
        pie.setCenterTextColor(Color.getHSBColor(0, 1, 1));
        f.add(new ChartPanel(chart){
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(400, 400);
            }
        });
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new TestRing()::display);
    }
}