import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Demo {

    private final XYSeries _timeSeries = new XYSeries("Time Series");
    boolean _shouldPaint;

    private void createAndShowGUI() {

        JToggleButton fillChart = new JToggleButton("Fill chart") ;
        fillChart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JToggleButton toggleButton = (JToggleButton)e.getSource();
                if(toggleButton.isSelected()) {
                    _timeSeries.clear();
                    _shouldPaint = true;
                    fillChart();
                } else {
                    _shouldPaint = false;
                }
            }
        });

        JPanel content = new JPanel(new BorderLayout());
        content.add(getFreeChartPanel(), BorderLayout.CENTER);
        content.add(fillChart, BorderLayout.SOUTH);

        JFrame frame = new JFrame("Demo");      
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(content);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private JPanel getFreeChartPanel() {
        String title = "Time series example";

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(_timeSeries); // series is added only once!

        JFreeChart chart = ChartFactory.createXYLineChart(title, "Array elements", "Time (in millis)", dataset, 
                                                         PlotOrientation.VERTICAL, true, true, false);       
        XYPlot plot = chart.getXYPlot();
        plot.setRenderer(new XYLineAndShapeRenderer(true, true));
        plot.setDomainCrosshairVisible(true);
        plot.setRangeCrosshairVisible(true);
        plot.getDomainAxis().setRange(0, 1000); // Number of elements - top visible: 1000
        plot.getRangeAxis().setRange(0, 4000); // Time employed to do the sort - top visible: 4 seconds (4k millis)        

        return new ChartPanel(chart);
    }

    /**
     * You should do your own implementation of this method.
     */
    private void fillChart() {
        Timer timer = new Timer(500, new ActionListener() {

            long lastTimeMillis = System.currentTimeMillis();
            int domainAxis = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                if(_shouldPaint) {
                    long currentTimeMillis = System.currentTimeMillis();
                    long rangeAxisValue = (long)((currentTimeMillis - lastTimeMillis) * Math.random());
                    int domainAxisValue = domainAxis + 100;

                    _timeSeries.add(domainAxisValue, rangeAxisValue);
                    // Note this is the unique line that has an effect on the graphic

                    lastTimeMillis = currentTimeMillis;
                    domainAxis = domainAxisValue;

                } else {
                    Timer timer = (Timer)e.getSource();
                    timer.stop();
                }
            }
        });

        timer.setDelay(1500);
        timer.start();
    }

    public static void main(String[] args) {   
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Demo().createAndShowGUI();
            }
        });
    }    
}