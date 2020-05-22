import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import org.jfree.chart.*;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.entity.XYItemEntity;
import org.jfree.chart.labels.StandardXYSeriesLabelGenerator;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
 * @see http://stackoverflow.com/a/38711095/230513
 * @see http://www.jfree.org/forum/viewtopic.php?f=3&t=30569
 */
public class SeriesAndPointDragAndMove extends ApplicationFrame
    implements ChartMouseListener, MouseListener, MouseMotionListener {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                SeriesAndPointDragAndMove app = new SeriesAndPointDragAndMove("Plot");
                app.pack();
                RefineryUtilities.centerFrameOnScreen(app);
                app.setVisible(true);
            }
        });
    }

    private boolean canMove = false;
    private double finalMovePointY = 0;
    private ChartRenderingInfo info = null;
    private double initialMovePointY = 0;
    private JFreeChart jFreeChart = null;
    private ChartPanel chartPanel = null;
    private XYSeries series = new XYSeries("Series");
    private XYSeriesCollection collection = new XYSeriesCollection();
    private XYItemEntity xyItemEntity = null;

    public SeriesAndPointDragAndMove(String paramString) {
        super(paramString);
        jFreeChart = ChartFactory.createXYLineChart(
            "Drag Point", "Points (Index)", "Velocity (m/s)",
            createDataset(), PlotOrientation.VERTICAL, true, true, false);
        chartPanel = new ChartPanel(jFreeChart) {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(640, 480);
            }
        };
        chartPanel.addChartMouseListener(this);
        chartPanel.addMouseMotionListener(this);
        chartPanel.addMouseListener(this);
        chartPanel.setAutoscrolls(false);
        chartPanel.setMouseZoomable(false);
        this.info = chartPanel.getChartRenderingInfo();
        XYPlot localXYPlot = (XYPlot) jFreeChart.getPlot();
        XYItemRenderer localXYItemRenderer = localXYPlot.getRenderer();
        localXYItemRenderer.setSeriesStroke(0, new BasicStroke(2.0F));
        XYLineAndShapeRenderer localXYLineAndShapeRenderer
            = (XYLineAndShapeRenderer) localXYPlot.getRenderer();
        localXYLineAndShapeRenderer.setBaseShapesVisible(true);
        localXYLineAndShapeRenderer.setSeriesFillPaint(0, Color.white);
        localXYLineAndShapeRenderer.setUseFillPaint(true);
        localXYLineAndShapeRenderer.setLegendItemToolTipGenerator(
            new StandardXYSeriesLabelGenerator("Tooltip {0}"));
        ValueAxis range = localXYPlot.getRangeAxis();
        range.setLowerBound(0);
        range.setUpperBound(20);
        setContentPane(chartPanel);
    }

    @Override
    public void chartMouseClicked(ChartMouseEvent paramChartMouseEvent) {
    }

    @Override
    public void chartMouseMoved(ChartMouseEvent paramChartMouseEvent) {
    }

    public XYDataset createDataset() {
        for (int i = 0; i < 8; i++) {
            series.add(i, 4);
        }
        collection.addSeries(series);
        return collection;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        movePoint(e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
        canMove = false; // stop movement if cursor is out from the chart area
        initialMovePointY = 0;
        chartPanel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }

    public void mouseMoved(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
        int x = e.getX(); // initialized point whenenver mouse is pressed
        int y = e.getY();
        EntityCollection entities = this.info.getEntityCollection();
        ChartMouseEvent cme = new ChartMouseEvent(jFreeChart, e, entities
            .getEntity(x, y));
        ChartEntity entity = cme.getEntity();
        if ((entity != null) && (entity instanceof XYItemEntity)) {
            xyItemEntity = (XYItemEntity) entity;
        } else if (!(entity instanceof XYItemEntity)) {
            xyItemEntity = null;
            return;
        }
        if (xyItemEntity == null) {
            return; // return if not pressed on any series point
        }
        Point pt = e.getPoint();
        XYPlot xy = jFreeChart.getXYPlot();
        Rectangle2D dataArea = chartPanel.getChartRenderingInfo()
            .getPlotInfo().getDataArea();
        Point2D p = chartPanel.translateScreenToJava2D(pt);
        initialMovePointY = xy.getRangeAxis().java2DToValue(p.getY(), dataArea,
            xy.getRangeAxisEdge());
        canMove = true;
        chartPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // stop dragging on mouse released
        canMove = false;
        initialMovePointY = 0;
        chartPanel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }

    public void movePoint(MouseEvent me) {
        if (canMove) {
            int itemIndex = xyItemEntity.getItem();
            Point pt = me.getPoint();
            XYPlot xy = jFreeChart.getXYPlot();
            Rectangle2D dataArea = chartPanel.getChartRenderingInfo()
                .getPlotInfo().getDataArea();
            Point2D p = chartPanel.translateScreenToJava2D(pt);
            finalMovePointY = xy.getRangeAxis().java2DToValue(p.getY(),
                dataArea, xy.getRangeAxisEdge());
            double difference = finalMovePointY - initialMovePointY;
            if (series.getY(itemIndex).doubleValue()
                + difference > xy.getRangeAxis().getRange().getLength()
                || series.getY(itemIndex).doubleValue()
                + difference < 0.0D) {
                initialMovePointY = finalMovePointY;
            }
            // retrict movement for upper and lower limit (upper limit
            // should be as per application needs)
            double targetPoint = series.getY(itemIndex).doubleValue() + difference;
            if (targetPoint > 15 || targetPoint < 0) {
                return;
            } else {
                series.update(Integer.valueOf(itemIndex), Double.valueOf(targetPoint));
            }
            jFreeChart.fireChartChanged();
            chartPanel.updateUI();
            initialMovePointY = finalMovePointY;
        }
    }

    public void moveSeries(MouseEvent me) {
        if (canMove) {
            Point pt = me.getPoint();
            XYPlot xy = jFreeChart.getXYPlot();
            Rectangle2D dataArea = chartPanel.getChartRenderingInfo()
                .getPlotInfo().getDataArea();
            Point2D p = chartPanel.translateScreenToJava2D(pt);
            finalMovePointY = xy.getRangeAxis().java2DToValue(p.getY(),
                dataArea, xy.getRangeAxisEdge());
            double difference = finalMovePointY - initialMovePointY;

            for (int i = 0; i < series.getItemCount(); i++) {
                System.out.println(series.getItemCount());
                if (series.getY(i).doubleValue() + difference > xy.getRangeAxis().getRange().getLength()
                    || series.getY(i).doubleValue()
                    + difference < 0.0D) {
                    initialMovePointY = finalMovePointY;
                }
            }

            // retrict movement for upper and lower limit (upper limit
            // should be as per application needs)
            for (int i = 0; i < series.getItemCount(); i++) {
                double targetPoint = series.getY(i)
                    .doubleValue()
                    + difference;
                if (targetPoint > 50 || targetPoint < 0) {
                    return;
                }
            }
            for (int i = 0; i < series.getItemCount(); i++) {
                double targetPoint = series.getY(i)
                    .doubleValue()
                    + difference;
                series.update(Integer.valueOf(i), Double.valueOf(targetPoint));
            }
            jFreeChart.fireChartChanged();
            chartPanel.updateUI();
            initialMovePointY = finalMovePointY;
        }
    }
}