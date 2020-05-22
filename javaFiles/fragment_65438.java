import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class ShowAndWaitBuiltInAlert extends Application {
    @Override public void start(Stage stage) {
        Button showDialog = new Button("Show Dialog");
        showDialog.setOnAction(event -> {
            Alert dialog = new Alert(
                    Alert.AlertType.CONFIRMATION,
                    "Are you sure you want to exit the Dialog Demo Application?"
            );
            dialog.showAndWait()
                    .filter(response -> response.equals(ButtonType.OK))
                    .ifPresent(response -> stage.close());
        });

        stage.setScene(new Scene(showDialog));
        stage.show();
    }

    public static void main(String[] args) { launch(args); }
}