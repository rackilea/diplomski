import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.stream.Stream;

public class GameBoardDemo extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        ToggleGroup tg = new ToggleGroup();
        RadioButton size1 = new RadioButton("5 X 5");
        RadioButton size2 = new RadioButton("5 X 10");
        RadioButton size3 = new RadioButton("10 X 10");
        RadioButton size4 = new RadioButton("10 X 15");
        RadioButton size5 = new RadioButton("15 X 15");
        Stream.of(size1, size2, size3, size4, size5).forEach(rb -> {
            rb.setToggleGroup(tg);
            rb.setId(rb.getText());
        });
        GridPane options = new GridPane();
        options.setHgap(10);
        options.addRow(0, size1, size2, size3, size4, size5);

        GridPane board = new GridPane();
        board.setPrefSize(800, 500);
        ScrollPane scrollBoard = new ScrollPane(board);
        VBox.setVgrow(scrollBoard, Priority.ALWAYS);

        tg.selectedToggleProperty().addListener((obs, old, val) -> {
            RadioButton rb = (RadioButton) val;
            double rows, columns;
            switch (rb.getText()) {
                case "5 X 5":
                    rows = 5;
                    columns = 5;
                    break;
                case "5 X 10":
                    rows = 5;
                    columns = 10;
                    break;
                case "10 X 10":
                    rows = 10;
                    columns = 10;
                    break;
                case "10 X 15":
                    rows = 10;
                    columns = 15;
                    break;
                default:
                    rows = 15;
                    columns = 15;
            }
            board.getChildren().clear();
            for (int rowIndex = 0; rowIndex < rows; rowIndex++) {
                for (int columnIndex = 0; columnIndex < columns; columnIndex++) {
                    Rectangle node = new Rectangle(100, 100);
                    node.setFill(Color.LIGHTBLUE);
                    node.setStroke(Color.BLACK);
                    StackPane terrainNode = new StackPane(node, new Label("Item " + rowIndex + "-" + columnIndex));
                    board.add(terrainNode, columnIndex, rowIndex);
                }
            }
        });
        VBox root = new VBox();
        root.setPadding(new Insets(10));
        root.setSpacing(15);
        root.getChildren().addAll(options, scrollBoard);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("BoardGame");
        primaryStage.show();
    }
}