import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class ShowAndWaitBuiltInDialog extends Application {    
    @Override public void start(Stage stage) {
        Button showDialog = new Button("Show Dialog");
        showDialog.setOnAction(e -> {
            Dialog<ButtonType> dialog = new Dialog<>();
            dialog.setTitle("Dialog Demo");
            dialog.setHeaderText("Confirm Exit");
            dialog.setContentText("Are you sure you want to exit the Dialog Demo Application?");
            ButtonType exit = new ButtonType("Exit", ButtonBar.ButtonData.OK_DONE);
            dialog.getDialogPane().getButtonTypes().addAll(
                    exit, ButtonType.CANCEL
            );
            dialog.showAndWait()
                    .filter(response -> response.equals(exit))
                    .ifPresent(response -> stage.close());
        });

        stage.setScene(new Scene(showDialog));
        stage.show();
    }

    public static void main(String[] args) { launch(args); }
}