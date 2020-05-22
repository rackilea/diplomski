public class PerformanceAnalyzerController {

    @FXML private BarChart<String, Number> barChart;

    @FXML
    private void performAnalysisOperation(ActionEvent event) {
        //Performing analysis operation

        ObservableList<XYChart.Data<String, Number>> data = handler.getItemsGraphicsStatisitics();
        XYChart.Series<String, Number> series = new XYChart.Series<>("Series Name", data);

        barchart.getData().setAll(series);
        graphHandler.getChildren().add(barchart);
    }

}