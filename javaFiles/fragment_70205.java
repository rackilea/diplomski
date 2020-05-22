import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TableWithMappedBooleans extends Application {

    private static final List<String> groups = Arrays.asList("Group 1", "Group 2", "Group 3", "Group 4");

    @Override
    public void start(Stage primaryStage) {

        TableView<AttributeRow> attributeTable = new TableView<>();
        attributeTable.setEditable(true);

        TableColumn<AttributeRow, String> attributeColumn = new TableColumn<>("Attribute");
        attributeColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());

        attributeTable.getColumns().add(attributeColumn);

        for (String group : groups) {
            TableColumn<AttributeRow, Boolean> groupColumn = new TableColumn<>(group);
            groupColumn.setCellFactory(CheckBoxTableCell.forTableColumn(groupColumn));
            groupColumn.setCellValueFactory(cellData -> cellData.getValue().activeProperty(group));
            attributeTable.getColumns().add(groupColumn);
        }

        // generate data:
        for (int i = 1 ; i <= 10; i++) {
            AttributeRow row = new AttributeRow(groups);
            row.setName("Attribute "+i);
            attributeTable.getItems().add(row);
        }

        // button to select everything:

        Button selectAll = new Button("Select all");
        selectAll.setOnAction(e -> {
            for (AttributeRow row : attributeTable.getItems()) {
                for (String group : groups) {
                    row.setActive(group, true);
                }
            }
        });

        // for debugging, to check data are updated from check boxes:
        Button dumpDataButton = new Button("Dump data");
        dumpDataButton.setOnAction(e -> {
            for (AttributeRow row : attributeTable.getItems()) {
                String groupList = groups.stream()
                        .filter(group -> row.isActive(group))
                        .collect(Collectors.joining(", "));
                System.out.println(row.getName() + " : " + groupList);
            }
            System.out.println();
        });

        HBox buttons = new HBox(5, selectAll, dumpDataButton);
        buttons.setAlignment(Pos.CENTER);
        buttons.setPadding(new Insets(5));

        BorderPane root = new BorderPane(attributeTable, null, null, buttons, null);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}