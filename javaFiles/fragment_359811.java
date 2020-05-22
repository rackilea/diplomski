public class LineChartValueMarker extends Application {

    private Line valueMarker = new Line();
    private XYChart.Series<Number, Number> series = new XYChart.Series<>();
    private NumberAxis yAxis;
    private double yShift;

    private void updateMarker() {
        // find maximal y value
        double max = 0;
        for (Data<Number, Number> value : series.getData()) {
            double y = value.getYValue().doubleValue();
            if (y > max) {
                max = y;
            }
        }
        // find pixel position of that value
        double displayPosition = yAxis.getDisplayPosition(max);
        // update marker
        valueMarker.setStartY(yShift + displayPosition);
        valueMarker.setEndY(yShift + displayPosition);
    }

    @Override
    public void start(Stage stage) {
        LineChart<Number, Number> chart = new LineChart<>(new NumberAxis(0, 100, 10), yAxis = new NumberAxis(0, 100, 10));

        series.getData().add(new XYChart.Data(0, 0));
        series.getData().add(new XYChart.Data(10, 20));

        chart.getData().addAll(series);
        Pane pane = new Pane();
        pane.getChildren().addAll(chart, valueMarker);
        Scene scene = new Scene(pane);

        // add new value on mouseclick for testing
        chart.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                series.getData().add(new XYChart.Data(series.getData().size() * 10, 30 + 50 * new Random().nextDouble()));
                updateMarker();
            }
        });

        stage.setScene(scene);
        stage.show();

        // find chart area Node
        Node chartArea = chart.lookup(".chart-plot-background");
        Bounds chartAreaBounds = chartArea.localToScene(chartArea.getBoundsInLocal());
        // remember scene position of chart area
        yShift = chartAreaBounds.getMinY();
        // set x parameters of the valueMarker to chart area bounds
        valueMarker.setStartX(chartAreaBounds.getMinX());
        valueMarker.setEndX(chartAreaBounds.getMaxX());
        updateMarker();
    }

    public static void main(String[] args) {
        launch();
    }
}