import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Transform;
import javafx.stage.Stage;

public class FlippedExampleChart extends Application {

    private LineChart<Number, Number> chart;

    @Override
    public void start(Stage primaryStage) throws Exception {
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();

        // Flip the axis
        // yAxis.setScaleY(-1);

        Rectangle r = new Rectangle(0, 0, 50, 100);
        r.setFill(Color.GREEN);

        this.chart = new LineChart<Number, Number>(xAxis, yAxis) {
            @Override
            public void layoutPlotChildren() {
                super.layoutPlotChildren();
                r.getTransforms().setAll(chartDisplayTransform(xAxis, yAxis));
                // note nodes don't get removed from the plot children, and this method may be
                // called often:
                if (!getPlotChildren().contains(r)) {
                    getPlotChildren().add(r);
                }
            }
        };
        this.chart.setAnimated(false);

        VBox vbox = new VBox(this.chart);

        Scene scene = new Scene(vbox, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.setHeight(600);
        primaryStage.setWidth(400);
        primaryStage.show();
    }

    private Transform chartDisplayTransform(NumberAxis xAxis, NumberAxis yAxis) {
        return new Affine(xAxis.getScale(), 0, xAxis.getDisplayPosition(0), 0, yAxis.getScale(),
                yAxis.getDisplayPosition(0));
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}