import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.collections.*;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.Random;

public class AreaChartSample extends Application {
    private static final String HEART_RATE = "Heart Rate";
    private static final String PEDALING_RATE = "Pedaling Rate";
    private static final String AVERAGE_SPEED = "Average Speed";

    private Random random = new Random(42);

    private NumberAxis xAxis = new NumberAxis();
    private NumberAxis yAxis = new NumberAxis();
    private AreaChart<Number, Number> chart = new AreaChart<>(xAxis, yAxis);

    private XYChart.Series<Integer, Double> heartRateSeries = new XYChart.Series<>(
            HEART_RATE, randomData(10)
    );
    private XYChart.Series<Integer, Double> cadenceSeries = new XYChart.Series<>(
            PEDALING_RATE, randomData(50)
    );
    private XYChart.Series<Integer, Double> speedSeries = new XYChart.Series<>(
            AVERAGE_SPEED, randomData(100)
    );

    private CheckBox heartRateCheck = new CheckBox(HEART_RATE);
    private CheckBox cadenceCheck = new CheckBox(PEDALING_RATE);
    private CheckBox speedCheck = new CheckBox(AVERAGE_SPEED);

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        HBox controls = new HBox(10, heartRateCheck, cadenceCheck, speedCheck);
        addSeriesListener(heartRateCheck.selectedProperty(), heartRateSeries);
        addSeriesListener(cadenceCheck.selectedProperty(), cadenceSeries);
        addSeriesListener(speedCheck.selectedProperty(), speedSeries);
        heartRateCheck.selectedProperty().set(true);
        cadenceCheck.selectedProperty().set(true);
        speedCheck.selectedProperty().set(true);

        chart.setTitle("Cycling");
        VBox layout = new VBox(10, chart, controls);
        layout.setPadding(new Insets(10));
        controls.setAlignment(Pos.CENTER);

        stage.setScene(new Scene(layout));
        stage.show();
    }

    private ObservableList<XYChart.Data<Integer, Double>> randomData(
            double offset
    ) {
        ObservableList<XYChart.Data<Integer, Double>> data = FXCollections.observableArrayList();

        for (int x = 0; x < 225; x++) {
            double y = random.nextDouble() * 30 + offset;
            data.add(new XYChart.Data<>(x, y));
        }

        return data;
    }

    @SuppressWarnings("unchecked")
    private void addSeriesListener(BooleanProperty selected, final XYChart.Series series) {
        selected.addListener((observable, wasSelected, isSelected) -> {
            if (isSelected) {
                chart.getData().add(series);
            } else {
                chart.getData().remove(series);
            }
        });
    }
}