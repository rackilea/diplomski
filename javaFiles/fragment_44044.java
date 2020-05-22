import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTick;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.event.ChartProgressEvent;
import org.jfree.chart.event.ChartProgressListener;
import org.jfree.chart.plot.PolarPlot;
import org.jfree.chart.renderer.DefaultPolarItemRenderer;
import org.jfree.chart.renderer.PolarItemRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.TextAnchor;

public class tests extends JFrame implements ChartProgressListener {

    private static final String title = "Archimedes' Spirals";
    private XYSeriesCollection result = new XYSeriesCollection();
    private DefaultPolarItemRenderer renderers = new DefaultPolarItemRenderer();
    private int i;

    public tests(String title) {
        super(title);
        JFreeChart chart = createChart(result);
        ChartPanel panel = new ChartPanel(chart);
        panel.setPreferredSize(new Dimension(500, 500));
        panel.setMouseZoomable(false);
        this.add(panel);
    }

    private JFreeChart createChart(XYDataset dataset) {
        ValueAxis radiusAxis = new NumberAxis();
        radiusAxis.setTickLabelsVisible(false);
        PolarItemRenderer renderer = new DefaultPolarItemRenderer();
        PolarPlot plot = new PolarPlot(dataset, radiusAxis, renderer) {

            @Override
            protected List refreshAngleTicks() {
                List<NumberTick> ticks = new ArrayList<NumberTick>();
                int delta = (int) this.getAngleTickUnit().getSize();
                for (int t = 0; t < 360; t += delta) {
                    int tp = (360 + 90 - t) % 360;
                    NumberTick tick = new NumberTick(
                        Double.valueOf(t), String.valueOf(tp),
                        TextAnchor.CENTER, TextAnchor.CENTER, 0.0);
                    ticks.add(tick);
                }
                return ticks;
            }
        };
        plot.setBackgroundPaint(new Color(0x00f0f0f0));
        plot.setRadiusGridlinePaint(Color.gray);
        plot.addCornerTextItem("r(θ) = θ; 0 < θ < 2π; +iπ/8");
        setFilled(dataset);
        plot.setRenderer(renderers);
        JFreeChart chart = new JFreeChart(
            title, JFreeChart.DEFAULT_TITLE_FONT, plot, true);
        chart.setBackgroundPaint(Color.white);
        chart.addProgressListener(this);
        return chart;
    }

    public static void main(String[] args) {
        tests demo = new tests(title);
        demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        demo.pack();
        demo.setLocationRelativeTo(null);
        demo.setVisible(true);
    }

    @Override
    public void chartProgress(ChartProgressEvent e) {
        if (e.getType() == ChartProgressEvent.DRAWING_FINISHED) {
            System.out.println(e);
            JFreeChart chart = e.getChart();
            draw();
        }
    }

    public void draw() {
        if (i < 8) {
            XYSeries series = new XYSeries(i + "π/8 " + "< θ < 2π+" + i + "π/8");
            for (int t = 0; t <= 1 * 360; t++) {
                series.add(90 - t - i * 45, t);
            }
            result.addSeries(series);
            setFilled(result);
            i++;
        }
    }

    private void setFilled(XYDataset dataset) {
        for (int i = 0; i < dataset.getSeriesCount(); i++) {
            renderers.setSeriesFilled(i, true);
        }
    }
}