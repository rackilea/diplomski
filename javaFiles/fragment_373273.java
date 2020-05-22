public void start(Stage stage) throws Exception {

    stage.setTitle("Test");
    final NumberAxis xAxis = new NumberAxis();
    final NumberAxis yAxis = new NumberAxis();
    xAxis.setLabel("X");
    final AreaChart<Number,Number> lineChart =
            new AreaChart<>(xAxis,yAxis);

    lineChart.setTitle("Test");

    XYChart.Series series1 = new XYChart.Series();
    series1.setName("S1");
    series1.getData().add(new XYChart.Data(0, 0));
    series1.getData().add(new XYChart.Data(20, 20));

    XYChart.Series series2 = new XYChart.Series();
    series2.setName("S2");
    series2.getData().add(new XYChart.Data(0, 0));
    series2.getData().add(new XYChart.Data(20, 10));

    Scene scene  = new Scene(lineChart,800,600);
    lineChart.getData().addAll(series1,series2);

    stage.setScene(scene);
    scene.getStylesheets().add("/test.css");
    stage.show();
}