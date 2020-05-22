import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DrawLines extends Application {

    @Override
    public void start(Stage primaryStage) {

        Pane pane = new Pane();
        Text text = new Text(150, 150, ".");

        pane.getChildren().add(text);
        text.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case DOWN:
                    leaveTrail(pane, text);
                    text.setY(text.getY() + 10);
                    break;
                case UP:
                    leaveTrail(pane, text);
                    text.setY(text.getY() - 10);
                    break;
                case LEFT:
                    leaveTrail(pane, text);
                    text.setX(text.getX() - 10);
                    break;
                case RIGHT:
                    leaveTrail(pane, text);
                    text.setX(text.getX() + 10);
                    break;
                default:
                    if (Character.isLetterOrDigit(e.getText().charAt(0)))
                        text.setText(e.getText());
            }
        });

        // Create a scene and place the pane in the stage
        Scene scene = new Scene(pane, 300, 300);
        primaryStage.setTitle("Draw a Line!");
        primaryStage.setScene(scene);
        primaryStage.show();
        text.requestFocus();
    }

    private void leaveTrail(Pane pane, Text text){
        Text newText = new Text(text.getText());
        pane.getChildren().add(newText);
        newText.setY(text.getY());
        newText.setX(text.getX());
    }
    public static void main(String[] args) {
        launch(args);
    }
}