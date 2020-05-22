import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

/**
 * Demonstrates how to draw layers of XYCharts.
 * https://forums.oracle.com/forums/thread.jspa?threadID=2435995 "Using StackPane to layer more different type charts"
 */
public class LayeredXyChartsSample extends Application {

    private XYChart.Series<Number, Number> lineSeries1;
    private XYChart.Series<Number, Number> lineSeries2;

    private List<NumberAxis> xAxes = new ArrayList<>();
    private NumberAxis yAxis;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        initSeries();

        // Close the application when the window is closed
        stage.setOnCloseRequest(t -> {
            Platform.exit();
            System.exit(0);
        });

        stage.setScene(
                new Scene(
                        layerCharts(
                                createLineChart1(),
                                createLineChart2()
                        )
                )
        );
        stage.show();
    }

    @SuppressWarnings("unchecked")
    private void initSeries() {
        lineSeries1 = new XYChart.Series(
                FXCollections.observableArrayList(
                        new XYChart.Data(1, 2),
                        new XYChart.Data(2, 10),
                        new XYChart.Data(3, 8),
                        new XYChart.Data(4, 4),
                        new XYChart.Data(5, 7),
                        new XYChart.Data(6, 5),
                        new XYChart.Data(7, 4),
                        new XYChart.Data(8, 8),
                        new XYChart.Data(9, 16.5),
                        new XYChart.Data(10, 13.9),
                        new XYChart.Data(11, 17),
                        new XYChart.Data(12, 10)
                )
        );

        lineSeries2 = new XYChart.Series(
                FXCollections.observableArrayList(
                        new XYChart.Data(1, 1),
                        new XYChart.Data(2, 2),
                        new XYChart.Data(3, 1.5),
                        new XYChart.Data(4, 3),
                        new XYChart.Data(5, 2.5),
                        new XYChart.Data(6, 5),
                        new XYChart.Data(7, 4),
                        new XYChart.Data(8, 8),
                        new XYChart.Data(9, 6.5),
                        new XYChart.Data(10, 13),
                        new XYChart.Data(11, 10),
                        new XYChart.Data(12, 20)
                )
        );

        createYaxis();
    }

    private void createYaxis() {
        yAxis = new NumberAxis();
        yAxis.setAutoRanging(false);
        yAxis.setPrefWidth(35);
        yAxis.setMinorTickCount(10);
        yAxis.setLowerBound(0);
        yAxis.setUpperBound(20);
    }

    private NumberAxis createXaxis() {
        NumberAxis xAxis = new NumberAxis();
        xAxis.setAutoRanging(false);
        xAxis.setLowerBound(-10);
        xAxis.setUpperBound(22);
        xAxes.add(xAxis);

        return xAxis;
    }

    @SuppressWarnings("unchecked")
    private LineChart<Number, Number> createLineChart1() {
        final LineChart<Number, Number> chart = new LineChart<>(createXaxis(), yAxis);
        setDefaultChartProperties(chart);
        chart.setCreateSymbols(false);
        chart.getData().addAll(lineSeries1);
        return chart;
    }

    @SuppressWarnings("unchecked")
    private LineChart<Number, Number> createLineChart2() {
        final LineChart<Number, Number> chart = new LineChart<>(createXaxis(), yAxis);
        setDefaultChartProperties(chart);
        chart.setCreateSymbols(false);
        chart.getData().addAll(lineSeries2);
        return chart;
    }

    private void setDefaultChartProperties(final XYChart<Number, Number> chart) {
        chart.setLegendVisible(false);
        chart.setAnimated(false);
    }

    @SafeVarargs
    private final StackPane layerCharts(final XYChart<Number, Number>... charts) {
        for (int i = 1; i < charts.length; i++) {
            configureOverlayChart(charts[i]);
        }

        StackPane stackpane = new StackPane();
        stackpane.getChildren().addAll(charts);

        stackpane.setOnScroll(event -> {
            double deltaX = event.getDeltaX();
            if (deltaX != 0) {
                for (NumberAxis xAxis : xAxes) {
                    xAxis.setUpperBound(xAxis.getUpperBound() - deltaX / 10);
                    xAxis.setLowerBound(xAxis.getLowerBound() - deltaX / 10);
                }
            }
        });

        return stackpane;
    }

    private void configureOverlayChart(final XYChart<Number, Number> chart) {
        chart.setAlternativeRowFillVisible(false);
        chart.setAlternativeColumnFillVisible(false);
        chart.setHorizontalGridLinesVisible(false);
        chart.setVerticalGridLinesVisible(false);
        chart.getXAxis().setVisible(false);
        chart.getYAxis().setVisible(false);

        chart.getStylesheets().addAll(getClass().getResource("/overlay-chart.css").toExternalForm());
    }
}