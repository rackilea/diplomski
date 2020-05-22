import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class LineChartWithRightPanel extends Application {

    private final Color[] RECT_COLORS = 
            new Color[] {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE};
    private final double RECT_WIDTH = 20 ;

    @Override
    public void start(Stage primaryStage) {

        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis(0, 1, 0.2);
        LineChart<Number, Number> chart = new LineChart<>(xAxis, yAxis);

        Region chartWithPanel = new Region() {

            private List<Rectangle> rectangles = 
                    Stream.of(RECT_COLORS)
                    .map(c -> new Rectangle(RECT_WIDTH, 0, c))
                    .collect(Collectors.toList());

            {
                getChildren().add(chart);
                getChildren().addAll(rectangles);
            }

            @Override
            protected void layoutChildren() {
                double w = getWidth();
                double h = getHeight();
                chart.resizeRelocate(0, 0, w-RECT_WIDTH, h);
                chart.layout();

                double chartMinY = yAxis.getLowerBound();
                double chartMaxY = yAxis.getUpperBound();
                double chartYRange = chartMaxY - chartMinY ;

                for (int i = 0 ; i < rectangles.size(); i++) {

                    // easier ways to do this in this example, 
                    // but this technique shows how to map "chart coords"
                    // to coords in this pane:

                    double rectMinYInChart = chartMinY + i * chartYRange / rectangles.size();
                    double rectMaxYInChart = chartMinY + (i+1) * chartYRange / rectangles.size();
                    double rectMinYInAxis = yAxis.getDisplayPosition(rectMinYInChart);
                    double rectMaxYInAxis = yAxis.getDisplayPosition(rectMaxYInChart);
                    double rectMinY = sceneToLocal(yAxis.localToScene(new Point2D(0, rectMinYInAxis))).getY();
                    double rectMaxY = sceneToLocal(yAxis.localToScene(new Point2D(0, rectMaxYInAxis))).getY();

                    rectangles.get(i).setHeight(Math.abs(rectMaxY - rectMinY));
                    rectangles.get(i).setX(w - RECT_WIDTH);
                    rectangles.get(i).setY(Math.min(rectMinY, rectMaxY));

                    Tooltip.install(rectangles.get(i), 
                            new Tooltip(String.format("%.2f - %.2f", rectMinYInChart, rectMaxYInChart)));
                }
            }
        };

        Series<Number, Number> series = new Series<>();
        series.setName("Data");
        Random rng = new Random();
        for (int i = 0; i < 20; i++) {
            series.getData().add(new Data<>(i, rng.nextDouble()));
        }
        chart.getData().add(series);

        BorderPane root = new BorderPane(chartWithPanel);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}