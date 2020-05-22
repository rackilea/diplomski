import javafx.application.*;
import javafx.collections.*;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.*;
import javafx.scene.chart.PieChart;
import javafx.scene.image.Image;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.*;

public class OffscreenImageRecorder extends Application {
    private static final Logger logger = Logger.getLogger(OffscreenImageRecorder.class.getName());

    private static final String IMAGE_TYPE = "png";
    private static final String IMAGE_FILENAME = "image." + IMAGE_TYPE;
    private static final String WORKING_DIR = System.getProperty("user.dir");
    private static final String IMAGE_PATH = new File(WORKING_DIR, IMAGE_FILENAME).getPath();

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss.SSS");
    private final Random random = new Random();

    private final int CHART_SIZE = 400;

    @Override
    public void start(Stage stage) throws IOException {
        Parent chart = createChart();
        Image  image = snapshot(chart);
        exportPng(SwingFXUtils.fromFXImage(image, null), IMAGE_PATH);

        Platform.exit();
    }

    private Parent createChart() {
        // create a chart.
        final PieChart chart = new PieChart();
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Grapefruit", random.nextInt(30)),
                        new PieChart.Data("Oranges", random.nextInt(30)),
                        new PieChart.Data("Plums", random.nextInt(30)),
                        new PieChart.Data("Pears", random.nextInt(30)),
                        new PieChart.Data("Apples", random.nextInt(30))
                );
        chart.setData(pieChartData);
        chart.setTitle("Imported Fruits - " + dateFormat.format(new Date()));

        // It is important for snapshots that the chart is not animated
        // otherwise we could get a snapshot of the chart before the
        // data display has been animated in.
        chart.setAnimated(false);

        chart.setMinSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);
        chart.setPrefSize(CHART_SIZE, CHART_SIZE);
        chart.setMaxSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);

        return chart;
    }

    private Image snapshot(final Parent sourceNode) {
        // Note: if the source node is not in a scene, css styles will not
        // be applied during a snapshot which may result in incorrect rendering.
        final Scene snapshotScene = new Scene(sourceNode);

        return sourceNode.snapshot(
                new SnapshotParameters(),
                null
        );
    }

    private void exportPng(BufferedImage image, String filename) {
        try {
            ImageIO.write(image, IMAGE_TYPE, new File(filename));

            logger.log(Level.INFO, "Wrote image to: " + filename);
        } catch (IOException ex) {
            logger.log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}