public class AssignedReportController {

    @FXML
    private BarChart<String, Number> barchart1 ;


    private XYChart.Series<String, Number> set1 ;

    public void initialize() {
        set1 = new XYChart.Series<>();
        barChart1.getData().add(set1);
    }

    public void setDates(String date1, String date2, int amount) {
        String totalDate = date1 + " - " + date2 ;
        set1.getData().add(new XYChart.Data<>(totalDate, amount));
    }

    // ...
}