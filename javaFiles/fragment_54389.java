private void changeScene(Stage stage, int i) {
    series1.setData(FXCollections.observableArrayList(
        new XYChart.Data<String, Number>("A", 200),
        new XYChart.Data<String, Number>("B", 250),
        new XYChart.Data<String, Number>("C", 225)));
    sbc.setData(FXCollections.singletonObservableList(series1));
}