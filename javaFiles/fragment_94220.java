import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.stage.Stage;

public class ScatterChartExample extends Application {

    @Override
    public void start(Stage primaryStage) {

        ScatterChart<Number, Number> chart = new ScatterChart<>(new NumberAxis(), new NumberAxis());

        chart.setId("bifurcation-diagram");

        Series<Number, Number> series = new Series<>();
        chart.getData().add(series);

        for (int i = 0 ; i <= 100; i++) {
            double lambda = 4.0 * i / 100 ;
            double x = 0.5 ;
            for (int j = 0 ; j < 100 ; j++) {
                x = lambda * x * (1-x);
            }
            for (int j = 0 ; j < 50; j++) {
                series.getData().add(new Data<>(lambda, x));
                x = lambda * x * (1-x);
            }
        }

        Scene scene = new Scene(chart, 1200, 800);
        scene.getStylesheets().add("bifurcation.css");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}