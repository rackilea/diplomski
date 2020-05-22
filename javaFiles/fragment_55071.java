import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
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

        fnLabel.prefWidthProperty().bind(firstNameColumn.widthProperty());
        fnLabel.minWidthProperty().bind(firstNameColumn.widthProperty());
        lnLabel.prefWidthProperty().bind(lastNameColumn.widthProperty());
        lnLabel.minWidthProperty().bind(lastNameColumn.widthProperty());
        emailLabel.prefWidthProperty().bind(emailColumn.widthProperty());
        emailLabel.minWidthProperty().bind(emailColumn.widthProperty());

        HBox labels = new HBox(fnLabel, lnLabel, emailLabel);

        BorderPane root = new BorderPane(table);
        root.setBottom(labels);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}