import javafx.application.Application;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MaintenanceWindow extends Application {
    private TableView<String> table;
    private TextField input;
    private Stage myStage;

    private static final String[] ITEMS = { "apples", "oranges", "peaches", "pears" };

    @Override
    public void start(Stage stage) throws Exception {
        myStage = stage;
        final Label label = new Label("list");
        label.setFont(new Font("Arial", 20));

        VBox vbox = new VBox(
                5,
                label, table(), textFields(), addRemove()
        );
        vbox.setPadding(new Insets(10, 0, 0, 10));

        BorderPane bP = new BorderPane();
        bP.setTop(menuBar());
        bP.setCenter(vbox);

        stage.setScene(new Scene(bP, 700, 800));
        stage.show();
    }

    private MenuBar menuBar() {
        Menu fileMenu = new Menu("_Add/Remove From DropDowns");
        MenuItem locationAdd = new MenuItem("Location DropDowns Add");
        locationAdd.setOnAction(e -> addButtonClicked());
        MenuItem locationRemove = new MenuItem("Location DropDowns Remove");
        locationRemove.setOnAction(e -> deleteButtonClicked());
        MenuItem exit = new MenuItem("Exit");
        exit.setOnAction(e -> closeApp());
        fileMenu.getItems().addAll(
                locationAdd,
                new SeparatorMenuItem(),
                locationRemove,
                new SeparatorMenuItem(),
                exit
        );

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu);
        return menuBar;
    }

    private TableView<String> table() {
        TableColumn<String, String> tColumn = new TableColumn<>("String");
        tColumn.setMinWidth(250);
        tColumn.setCellValueFactory(
                cellData -> new ReadOnlyStringWrapper(cellData.getValue())
        );
        table = new TableView<>();
        table.getItems().addAll(ITEMS);
        table.getColumns().add(tColumn);

        return table;
    }

    private void addButtonClicked() {
        if (!(input.getText() == null || "".equals(input.getText().trim())) {
            table.getItems().add(input.getText());
            input.clear();
        }
    }

    private void deleteButtonClicked() {
        table.getItems().removeAll(
                table.getSelectionModel().getSelectedItems()
        );
    }

    private HBox textFields() {
        input = new TextField();
        input.setPromptText("Input");
        input.setMinWidth(75);

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10, 10, 10, 10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(input);

        return hBox;
    }

    private HBox addRemove() {
        Button addButton = new Button("Add");
        addButton.setOnAction(e -> addButtonClicked());
        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(e -> deleteButtonClicked());
        Button closeButton = new Button("Close Window");
        closeButton.setOnAction(e -> closeApp());

        HBox hBox2 = new HBox(
                10,
                addButton, deleteButton, closeButton
        );
        hBox2.setPadding(new Insets(10, 10, 10, 10));
        hBox2.setSpacing(10);

        return hBox2;
    }

    private void closeApp() {
        myStage.close();
    }
}