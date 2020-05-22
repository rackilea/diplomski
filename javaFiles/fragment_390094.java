import java.util.stream.Stream;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class LineTest extends Application {

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        Line line1 = new Line(50, 50, 150, 150);
        line1.setStroke(Color.RED);

        Line line2 = new Line(200, 150, 300, 50);
        line2.setStroke(Color.BLUE);

        pane.getChildren().addAll(line1, line2);

        ComboBox<Integer> choice = new ComboBox<>(FXCollections.observableArrayList(0, 100));
        choice.getSelectionModel().selectedItemProperty().addListener((obs, oldValue, newValue) -> line1.setLayoutX(newValue));

        Button showValuesButton = new Button("Show all values");
        showValuesButton.setOnAction(event -> {
            Stream.of(line1, line2).forEach(line -> {
                System.out.printf("Layout x,y: [%.1f, %.1f]%n", line.getLayoutX(), line.getLayoutY());
                System.out.printf("Start: [%.1f, %.1f] End: [%.1f, %.1f]%n", line.getStartX(), line.getStartY(), line.getEndX(), line.getEndY());
                System.out.printf("Bounds in parent: %s%n", line.getBoundsInParent());

            });
            System.out.println("Bounds intersect? "+line1.getBoundsInParent().intersects(line2.getBoundsInParent()));
        });

        HBox controls = new HBox(5, new Label("Red layout x:"), choice, showValuesButton);
        controls.setAlignment(Pos.CENTER);
        controls.setPadding(new Insets(5));

        BorderPane root = new BorderPane();
        root.setCenter(pane);
        root.setBottom(controls);

        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}