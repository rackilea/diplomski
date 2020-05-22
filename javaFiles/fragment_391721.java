import java.util.Random;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.stage.Stage;

public class LineChartWithEventHandlers extends Application {

    @Override
    public void start(Stage primaryStage) {

        LineChart<Number, Number> chart = new LineChart<>(new NumberAxis(), new NumberAxis());
        Series<Number, Number> series = new Series<>();
        series.setName("Data");

        chart.getData().add(series);

        // handler for clicking on line:
        series.getNode().setOnMouseClicked(e -> System.out.println("Click on series"));

        Random rng = new Random();
        for (int x = 0 ; x <= 20 ; x++) {
            Data<Number, Number> data = new Data<>(x, rng.nextInt(100));
            series.getData().add(data);

            // handler for clicking on data point:
            data.getNode().setOnMouseClicked(e -> 
                System.out.printf("Click on data [%d, %d]%n", data.getXValue(), data.getYValue()));
        }

        Scene scene = new Scene(chart);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}