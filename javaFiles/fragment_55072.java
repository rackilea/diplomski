import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class TableWithLabelsBelowColumns extends Application {

    @Override
    public void start(Stage primaryStage) {
        TableView<Void> table = new TableView<>();
        table.getItems().add(null);

        TableColumn<Void, Void> firstNameColumn = new TableColumn<>("First Name");
        TableColumn<Void, Void> lastNameColumn = new TableColumn<>("Last Name");
        TableColumn<Void, Void> emailColumn = new TableColumn<>("Email");
        table.getColumns().add(firstNameColumn);
        table.getColumns().add(lastNameColumn);
        table.getColumns().add(emailColumn);

        Label fnLabel = new Label("FN");
        Label lnLabel = new Label("LN");
        Label emailLabel = new Label("E");

        Pane labelPane = new Pane(fnLabel, lnLabel, emailLabel) {
            @Override
            protected void layoutChildren() {
                double fnWidth = firstNameColumn.getWidth();
                double fnHeight = fnLabel.prefHeight(fnWidth);
                fnLabel.resizeRelocate(0, 0, fnWidth, fnHeight);

                double lnWidth = lastNameColumn.getWidth();
                double lnHeight = lnLabel.prefHeight(lnWidth);
                lnLabel.resizeRelocate(fnWidth, 0, lnWidth, lnHeight);

                double emailWidth = emailColumn.getWidth();
                double emailHeight = emailLabel.prefHeight(emailWidth);
                emailLabel.resizeRelocate(fnWidth+lnWidth, 0, emailWidth, emailHeight);
            }
        };
        ChangeListener<? super Number> listener = (obs, oldValue, newValue) -> labelPane.requestLayout();
        firstNameColumn.widthProperty().addListener(listener);
        lastNameColumn.widthProperty().addListener(listener);
        emailColumn.widthProperty().addListener(listener);

        BorderPane root = new BorderPane(table);
        root.setBottom(labelPane);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}