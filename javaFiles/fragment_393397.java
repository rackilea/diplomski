import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Test extends Application {

    @Override
    public void start(Stage primaryStage) {
        Label[] labels = new Label[3];

        Button btn = new Button();
        btn.setText("Change Label 2 text to something else");
        btn.setLayoutX(220);
        btn.setLayoutY(250);

        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                labels[1].setText("Text changed");
            }
        });

        Pane root = new Pane();
        root.getChildren().add(btn);

        for (int i = 0; i < 3; i++) {

            labels[i] = new Label("Label " + i);
            labels[i].setId(String.valueOf(i));
            labels[i].setLayoutX(i * 60);
            labels[i].setLayoutY(i * 60);
            root.getChildren().add(labels[i]);
        }

        Scene scene = new Scene(root, 600, 500);

        primaryStage.setTitle("Instances");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}