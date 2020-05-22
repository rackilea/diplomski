import java.util.Arrays;
    import javafx.application.Application;
    import javafx.collections.FXCollections;
    import javafx.scene.Scene;
    import javafx.scene.chart.CategoryAxis;
    import javafx.scene.chart.NumberAxis;
    import javafx.scene.chart.StackedBarChart;
    import javafx.scene.chart.XYChart;
    import javafx.stage.Stage;

    public class HorizontalHistogramTest extends Application{


        final static String austria = "Austria";
        final static String brazil = "Brazil";
        final static String france = "France";
        final static String italy = "Italy";
        final static String usa = "USA";
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final StackedBarChart<Number, String> sbc =
        new StackedBarChart<Number,String>(yAxis, xAxis);
        final XYChart.Series<Number,String> series1 =
        new XYChart.Series<Number,String>();

@Override
public void start(Stage stage) {
    stage.setTitle("Bar Chart Sample");
    sbc.setTitle("Country Summary");
    xAxis.setLabel("Country");
    xAxis.setCategories(FXCollections.<String>observableArrayList(
            Arrays.asList(austria, brazil, france, italy, usa)));
    yAxis.setLabel("Percent");
    // plus value
    series1.getData().add(new XYChart.Data<Number,String>(10, austria));
    series1.getData().add(new XYChart.Data<Number,String>(50, brazil));
    series1.getData().add(new XYChart.Data<Number,String>(40, france));
    series1.getData().add(new XYChart.Data<Number,String>(50, italy));
    series1.getData().add(new XYChart.Data<Number,String>(60, usa));
    // minus value
    series1.getData().add(new XYChart.Data<Number,String>(-90, austria));
    series1.getData().add(new XYChart.Data<Number,String>(-50, brazil));
    series1.getData().add(new XYChart.Data<Number,String>(-60, france));
    series1.getData().add(new XYChart.Data<Number,String>(-50, italy));
    series1.getData().add(new XYChart.Data<Number,String>(-40, usa));

    Scene scene = new Scene(sbc, 800, 600);
    sbc.getData().addAll(series1);
    stage.setScene(scene);
    stage.show();
}

public static void main(String[] args) {
    launch(args);
}
}