class ShapeCurvePlot extends Polyline {
private class ResizeTimerTask extends TimerTask {
    private ShapeCurvePlot plot;

    public ResizeTimerTask(ShapeCurvePlot plot) {
        this.plot = plot;
    }

    /* (non-Javadoc)
     * @see java.util.TimerTask#run()
     */
    @Override
    public void run() {
        Task<Object> t = new Task<Object>() {
            @Override
            protected Object call() throws Exception {
                // "expensive calculation"
                Series series = plot.getSeries();
                double xOffset = series.valueAxis().getLeft();
                double yOffset = series.keyAxis().getLeft();
                double yScale = height / series.keyAxis().range();
                double xScale = width / series.valueAxis().range();

                plot.getPoints().clear();
                for (Map.Entry<Double, Double> item : series.data().entrySet()) {
                    double x = item.getValue();
                    double y = item.getKey();
                    plot.getPoints().addAll((x - xOffset) * xScale, (y - yOffset) * yScale);
                }
            }
        }

        new Thread(t).start();
    }
}

private static int RESIZE_DELAY_MS = 1000;
private final CurvePlot model;
private Timer resizeTimer;

public ShapeCurvePlot(CurvePlot model) {
    Objects.requireNonNull(model);
    this.model = model;
    strokeProperty().bind(model.strokeProperty());
    strokeWidthProperty().bind(model.strokeWidthProperty());
}

@Override
public boolean isResizable() {
    return true;
}

public Series getSeries() {
    return this.model.getSeries();
}

@Override
public void resize(double width, double height) {
    // cancel the current task (if any).
    if(this.resizeTimer != null) {
        this.resizeTimer.cancel();
        this.resizeTimer.purge();
        this.resizeTimer = null;
    }

    try {
        // create a new task that will be executed in 1 second.
        this.resizeTimer = new Timer();
        this.resizeTimer.schedule(new ResizeTimerTask(this), RESIZE_DELAY_MS);
    } catch (OutOfMemoryError oom) {
        oom.printStackTrace();
        if(this.resizeTimer != null) {
            this.resizeTimer.cancel();
            this.resizeTimer.purge();
            this.resizeTimer = null;
        }
    }
}