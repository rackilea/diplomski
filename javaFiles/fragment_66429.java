import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class BackgroundPadding_Demo extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        StackPane root = new StackPane();
        root.setStyle("-fx-background-color:lightblue;");
        Scene scene = new Scene(root, 500, 200);
        stage.setScene(scene);
        stage.show();

        StackPane controlBox1 = new StackPane(new Label("Box1"));
        controlBox1.setAlignment(Pos.TOP_LEFT);
        controlBox1.setMinSize(200, 100);
        controlBox1.setMaxSize(200, 100);
        controlBox1.setStyle(
                "-fx-background-color: transparent, #f4f4f4;" +
                        "-fx-background-insets:0, 5;" +
                        "-fx-background-radius: 5;" +
                        //"-fx-background-padding: 10;" +
                        "-fx-padding: 10;" +
                        "-fx-border-style: solid inside;" +
                        "-fx-border-width: 2;" +
                        "-fx-border-insets: 5;" +
                        "-fx-border-radius: 5;" +
                        "-fx-border-color: lightgrey;"
        );

        StackPane controlBox2 = new StackPane(new Label("Box2"));
        controlBox2.setAlignment(Pos.TOP_LEFT);
        controlBox2.setMinSize(200, 100);
        controlBox2.setMaxSize(200, 100);
        HBox.setMargin(controlBox2, new Insets(5));
        controlBox2.setStyle(
                "-fx-background-color: #f4f4f4;" +
                        "-fx-background-radius: 5;" +
                        //"-fx-background-padding: 10;" +
                        "-fx-padding: 10;" +
                        "-fx-border-style: solid inside;" +
                        "-fx-border-width: 2;" +
                        // "-fx-border-insets: 5;" +
                        "-fx-border-radius: 5;" +
                        "-fx-border-color: lightgrey;"
        );

        HBox hBox = new HBox(controlBox1, controlBox2);
        hBox.setSpacing(15);
        hBox.setAlignment(Pos.CENTER);
        root.getChildren().add(new Group(hBox));
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}