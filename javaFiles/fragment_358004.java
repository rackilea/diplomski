public class Horse extends Application {

    public static void main(String args[]) {
        launch(args);
    }

    private Line line;
    private NumberAxis yAxis;
    private Region plotArea;
    private Pane chartContent;

    @Override
    public void start(Stage primaryStage) throws Exception {
        final CategoryAxis xAxis = new CategoryAxis();
        yAxis = new NumberAxis();
        final AreaChart<String, Number> chart = new AreaChart<String, Number>(xAxis, yAxis);
        Series<String, Number> series = new Series<>();
        series.getData().add(new Data<>("foo", 50));
        series.getData().add(new Data<>("bar", 25));
        series.getData().add(new Data<>("baz", 125));

        chart.getData().add(series);

        plotArea = (Region) chart.lookup(".chart-plot-background");
        chartContent = (Pane) chart.lookup(".chart-content");
        line = new Line();
        chartContent.getChildren().add(line);
        primaryStage.setScene(new Scene(chart));
        primaryStage.show();

        chart.boundsInParentProperty().addListener((obs, oldValue, newValue) -> {
            update();
        });
        plotArea.boundsInLocalProperty().addListener((obs, oldValue, newValue) -> {
            update();
        });
        update();

    }

    private void update() {
        double location = yAxis.getDisplayPosition(100);
        Point2D a = plotArea.localToScene(new Point2D(0, location));
        Point2D b = plotArea.localToScene(new Point2D(plotArea.getWidth(), location));

        Point2D aTrans = chartContent.sceneToLocal(a);
        Point2D bTrans = chartContent.sceneToLocal(b);

        line.setStartX(aTrans.getX());
        line.setStartY(aTrans.getY());
        line.setEndX(bTrans.getX());
        line.setEndY(bTrans.getY());
    }

}