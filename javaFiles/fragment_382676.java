import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.swtchart.Chart;
import org.swtchart.IAxis;
import org.swtchart.ILineSeries;
import org.swtchart.ISeries;
import org.swtchart.ISeries.SeriesType;

/**
 * An example for area chart.
 */
public class AreaChartExample {

    private static final double[] ySeries1 = { 0.1, 0.38, 0.71, 0.92, 1.0 };

    private static final double[] ySeries2 = { 1.2, 3.53, 3.1, 0.1, 0.5 };

    /* Used to remember the location of the highlight point */
    private static int highlightX;
    private static int highlightY;

    /**
     * The main method.
     * 
     * @param args
     *            the arguments
     */
    public static void main(String[] args) {
        Display display = new Display();
        Shell shell = new Shell(display);
        shell.setText("Area Chart");
        shell.setSize(500, 400);
        shell.setLayout(new FillLayout());

        createChart(shell);

        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        display.dispose();
    }

    protected static boolean highlight;

    /**
     * create the chart.
     * 
     * @param parent
     *            The parent composite
     * @return The created chart
     */
    static public Chart createChart(Composite parent) {

        // create a chart
        final Chart chart = new Chart(parent, SWT.NONE);

        // set titles
        chart.getTitle().setText("Area Chart");

        // create line series
        ILineSeries lineSeries1 = (ILineSeries) chart.getSeriesSet()
                .createSeries(SeriesType.LINE, "line series 1");
        lineSeries1.setYSeries(ySeries1);
        lineSeries1.setLineColor(Display.getDefault().getSystemColor(
                SWT.COLOR_RED));
        lineSeries1.enableArea(true);

        ILineSeries lineSeries2 = (ILineSeries) chart.getSeriesSet()
                .createSeries(SeriesType.LINE, "line series 2");
        lineSeries2.setYSeries(ySeries2);
        lineSeries2.enableArea(true);

        // adjust the axis range
        chart.getAxisSet().adjustRange();

        /* Get the plot area and add the mouse listeners */
        final Composite plotArea = chart.getPlotArea();

        plotArea.addListener(SWT.MouseHover, new Listener() {

            @Override
            public void handleEvent(Event event) {
                IAxis xAxis = chart.getAxisSet().getXAxis(0);
                IAxis yAxis = chart.getAxisSet().getYAxis(0);

                double x = xAxis.getDataCoordinate(event.x);
                double y = yAxis.getDataCoordinate(event.y);

                ISeries[] series = chart.getSeriesSet().getSeries();

                double closestX = 0;
                double closestY = 0;
                double minDist = Double.MAX_VALUE;

                /* over all series */
                for (ISeries serie : series) {
                    double[] xS = serie.getXSeries();
                    double[] yS = serie.getYSeries();

                    /* check all data points */
                    for (int i = 0; i < xS.length; i++) {
                        /* compute distance to mouse position */
                        double newDist = Math.sqrt(Math.pow((x - xS[i]), 2)
                                + Math.pow((y - yS[i]), 2));

                        /* if closer to mouse, remember */
                        if (newDist < minDist) {
                            minDist = newDist;
                            closestX = xS[i];
                            closestY = yS[i];
                        }
                    }
                }

                /* set tooltip of closest data point */
                plotArea.setToolTipText(closestX + " " + closestY);

                /* remember closest data point */
                highlightX = xAxis.getPixelCoordinate(closestX);
                highlightY = yAxis.getPixelCoordinate(closestY);

                highlight = true;

                /* trigger repaint (paint highlight) */
                plotArea.redraw();
            }
        });

        plotArea.addListener(SWT.MouseMove, new Listener() {

            @Override
            public void handleEvent(Event arg0) {
                highlight = false;

                plotArea.redraw();
            }
        });

        plotArea.addListener(SWT.Paint, new Listener() {

            @Override
            public void handleEvent(Event event) {
                if (highlight) {
                    GC gc = event.gc;

                    gc.setBackground(Display.getDefault().getSystemColor(
                            SWT.COLOR_RED));
                    gc.setAlpha(128);

                    gc.fillOval(highlightX - 5, highlightY - 5, 10, 10);
                }
            }
        });

        return chart;
    }
}