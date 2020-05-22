import javafx.application.Application;
import javafx.beans.property.*;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

public class ShowAndWaitDialog extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Button showDialog = new Button("Show Dialog");
        showDialog.setOnAction(e -> {
            ConfirmationDialog dialog = new ConfirmationDialog(
                    "Would you like to exit the application?"
            );
            dialog.setY(stage.getY() + stage.getHeight() + 10);
            dialog.setX(stage.getX());
            dialog.showAndWait();
            if (dialog.isSelected()) {
                stage.close();
            }
        });
        stage.setScene(new Scene(showDialog));
        stage.show();
    }

    class ConfirmationDialog extends Stage {
        private VBox layout = new VBox();

        private ReadOnlyBooleanWrapper selected = new ReadOnlyBooleanWrapper();
        public boolean isSelected() {
            return selected.get();
        }
        public ReadOnlyBooleanProperty selectedProperty() {
            return selected.getReadOnlyProperty();
        }

        public ConfirmationDialog(String question) {
            initStyle(StageStyle.UTILITY);
            initModality(Modality.APPLICATION_MODAL);

            layout.setSpacing(10);
            layout.setPadding(new Insets(10));

            createControls();

            layout.getChildren().addAll(
                    new Label(question),
                    createControls()
            );

            setScene(new Scene(layout));
            sizeToScene();  // workaround because utility stages aren't automatically sized correctly to their scene.
        }

        private HBox createControls() {
            final Button ok = new Button("OK");
            ok.setOnAction(e -> {
                selected.set(true);
                close();
            });

            final Button cancel = new Button("Cancel");
            cancel.setOnAction(e -> {
                selected.set(false);
                close();
            });

            final HBox controls = new HBox(10, ok, cancel);
            controls.setAlignment(Pos.CENTER_RIGHT);

            return controls;
        }
    }
}