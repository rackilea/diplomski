import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StackedBarChartExample extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        primaryStage.setTitle("StackedBarChart Experiments");

        CategoryAxis xAxis = new CategoryAxis();
        xAxis.getCategories().addAll("300", "302.5", "305");
        NumberAxis yAxis = new NumberAxis();

        StackedBarChart<String, Number> chart = new StackedBarChart(xAxis, yAxis);

        XYChart.Series<String, Number> series1 = new XYChart.Series();
        series1.setName("300");
        series1.getData().add(new XYChart.Data("A1", 25601.34));
        series1.getData().add(new XYChart.Data("A2", 20148.82));

        XYChart.Series<String, Number> series2 = new XYChart.Series();
        series2.setName("302.50");
        series2.getData().add(new XYChart.Data("B1", 57401.85));
        series2.getData().add(new XYChart.Data("B2", 41941.19));

        XYChart.Series<String, Number> series3 = new XYChart.Series();
        series3.setName("305");
        series3.getData().add(new XYChart.Data("C1", 45000.65));
        series3.getData().add(new XYChart.Data("C2", 44835.76));

        chart.getData().addAll(series1, series2, series3);

        VBox vbox = new VBox(chart);

        Scene scene = new Scene(vbox, 400, 600);
        primaryStage.setScene(scene);
        primaryStage.setHeight(400);
        primaryStage.setWidth(600);
        primaryStage.show();

        chart.getData().forEach((t) -> {
            t.getData().forEach((j) -> {
                if (j.getXValue().equals("A1") || j.getXValue().equals("B1") || j.getXValue().equals("C1")) {
                    j.getNode().setStyle("-fx-background-color: red");
                }
                else {
                    j.getNode().setStyle("-fx-background-color: blue");
                }
            });
        });


    }

    public static void main(String[] args)
    {
        Application.launch(args);
    }
}