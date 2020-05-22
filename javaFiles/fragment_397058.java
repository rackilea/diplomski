import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class CountingButton extends Application {


    @Override
    public void start(Stage primaryStage) {

        Button button = new Button("Start");

        button.setOnAction(e -> {
            Thread thread = new Thread(() -> {
                for (int i = 0; i <= 5 ; i++) {
                    final String text = "Count: "+i ;
                    Platform.runLater(() -> button.setText(text));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException exc) {
                        exc.printStackTrace();
                    }
                }
            });
            thread.start();
        });

        primaryStage.setScene(new Scene(new StackPane(button), 120, 75));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}