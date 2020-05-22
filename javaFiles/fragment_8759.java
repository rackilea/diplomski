import java.util.Random;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        var scene = new Scene(new StackPane(createBarChart()), Color.TRANSPARENT);
        scene.getStylesheets().add("Main.css");

        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setScene(scene);

        primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode() == KeyCode.ESCAPE) {
                primaryStage.close();
            }
        });

        var bounds = Screen.getPrimary().getVisualBounds();
        primaryStage.setX(bounds.getMinX());
        primaryStage.setY(bounds.getMinY());
        primaryStage.setWidth(bounds.getWidth());
        primaryStage.setHeight(bounds.getHeight());

        primaryStage.show();
    }

    private BarChart<?, ?> createBarChart() {
        var chart = new BarChart<>(new CategoryAxis(), new NumberAxis(0, 20, 1));

        var random = new Random();

        var series = new Series<String, Number>();
        for (int i = 0; i < 20; i++) {
            var category = Integer.toString(i);
            series.getData().add(new Data<>(category, random.nextInt(15)));
            ((CategoryAxis) chart.getXAxis()).getCategories().add(category);
        }

        chart.getData().add(series);
        return chart;
    }

}