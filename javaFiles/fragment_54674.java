@Override
public void start(Stage stage) {
    stage.setTitle("A Title");

    // Root element
    BorderPane root = new BorderPane();

    // GridPane
    GridPane grid = new GridPane();
    grid.setPadding(new Insets(10,10,10,10));
    grid.setVgap(10);
    grid.add(new Button("Button 1"), 0, 0);
    grid.add(new Button("Button 2"), 0, 1);
    grid.add(new Button("Button 3"), 0, 2);

    // Chart
    final NumberAxis xAxis = new NumberAxis();
    final NumberAxis yAxis = new NumberAxis();
    final LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
    XYChart.Series series = new XYChart.Series();
    series.setName("Chart");
    series.getData().add(new XYChart.Data(1, 5));
    series.getData().add(new XYChart.Data(2, 10));
    lineChart.getData().add(series);

    root.setLeft(grid);
    root.setRight(lineChart);

    Scene scene = new Scene(root, 600, 300);

    stage.setScene(scene);
    stage.show();
}