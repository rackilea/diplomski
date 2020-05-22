ObservableList<XYChart.Series<Double, Double>> lineChartData = FXCollections.observableArrayList(
    new LineChart.Series<>("Series 1", FXCollections.observableArrayList(
        new XYChart.Data<>(0.0, 1.0),
        new XYChart.Data<>(1.2, 1.4),
        new XYChart.Data<>(2.2, 1.9),
        new XYChart.Data<>(2.7, 2.3), //max
        new XYChart.Data<>(2.9, 0.5))),
    new LineChart.Series<>("Series 2", FXCollections.observableArrayList(
        new XYChart.Data<>(0.0, 1.6),
        new XYChart.Data<>(0.8, 0.4),
        new XYChart.Data<>(1.4, 2.9), //max
        new XYChart.Data<>(2.1, 1.3),
        new XYChart.Data<>(2.6, 0.9)))
    );