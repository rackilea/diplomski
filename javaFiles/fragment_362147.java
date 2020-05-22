import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.stream.Stream;

public class DynamicStyling_Demo extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);
        Stream.of("Default", "Type1", "Type2", "Type3").forEach(type -> {
            Button button = new Button("Open " + type);
            button.setOnAction(e -> {
                Stage subStage = buildStage(type);
                subStage.initOwner(stage);
                if (!type.equalsIgnoreCase("default")) {
                    subStage.getScene().getStylesheets().add(this.getClass().getResource(type.toLowerCase() + ".css").toExternalForm());
                }
                subStage.show();
            });
            root.getChildren().add(button);
        });
        Scene sc = new Scene(root, 400, 400);
        sc.getStylesheets().add(this.getClass().getResource("base.css").toExternalForm());
        stage.setScene(sc);
        stage.show();
    }

    private Stage buildStage(String title) {
        Label label = new Label("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        label.setWrapText(true);
        VBox.setVgrow(label, Priority.ALWAYS);
        Button btn = new Button("Sample Button");
        VBox pane = new VBox(label, btn);
        pane.getStyleClass().add("my-pane");

        StackPane subRoot = new StackPane(pane);
        subRoot.setPadding(new Insets(10));

        Stage subStage = new Stage();
        subStage.setTitle(title);
        subStage.setScene(new Scene(subRoot, 300, 300));
        subStage.getScene().getStylesheets().add(this.getClass().getResource("base.css").toExternalForm());
        return subStage;
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}