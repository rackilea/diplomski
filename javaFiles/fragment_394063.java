private static final double[] xSeries = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
private static final double[] ySeries = { 0, -1.3, -2.0, -3.9, -5.6, -4.1, -5.3, -7.0, -3.9, -3.6, -1.1, 0 };

private static Font           font;

/**
 * The main method.
 *
 * @param args
 *            the arguments
 */
public static void main(String[] args)
{
    Display display = new Display();
    Shell shell = new Shell(display);
    shell.setText("Dive Profile");
    shell.setSize(500, 400);
    shell.setLayout(new FillLayout());

    display.loadFont("baz.ttf");

    font = new Font(display, "Baz", 12, SWT.NONE);

    createChart(shell);

    shell.open();
    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
        {
            display.sleep();
        }
    }
    display.dispose();

    font.dispose();
}

/**
 * create the chart.
 *
 * @param parent
 *            The parent composite
 * @return The created chart
 */
static public Chart createChart(Composite parent)
{
    // create a chart
    Chart chart = new Chart(parent, SWT.NONE);
    // set titles
    chart.getTitle().setText("Dive profile");
    chart.getAxisSet().getXAxis(0).getTitle().setText("Time");
    chart.getAxisSet().getYAxis(0).getTitle().setText("Depth");
    chart.getAxisSet().getYAxis(0).getTick().setFont(font);
    chart.getAxisSet().getXAxis(0).getTick().setFont(font);
    // create scatter series
    ILineSeries series = (ILineSeries) chart.getSeriesSet().createSeries(SeriesType.LINE, "series");
    series.setLineStyle(LineStyle.SOLID);
    series.enableArea(true);
    series.setXSeries(xSeries);
    series.setYSeries(ySeries);
    // adjust the axis range
    chart.getAxisSet().adjustRange();
    return chart;
}